package yunsinsa.yunsinsashop.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yunsinsa.yunsinsashop.domain.entity.Order;
import yunsinsa.yunsinsashop.domain.entity.OrderDetail;
import yunsinsa.yunsinsashop.domain.entity.OrderStatus;
import yunsinsa.yunsinsashop.domain.model.Address;
import yunsinsa.yunsinsashop.domain.repository.MemberRepository;
import yunsinsa.yunsinsashop.domain.repository.OrderRepository;
import yunsinsa.yunsinsashop.domain.repository.ProductRepository;
import yunsinsa.yunsinsashop.presentation.dto.OrderDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final PaymentService paymentService;
    private final MemberRepository memberRepository;

    /**
     * 주문생성 및 재고확인
     *
     */
    @Transactional
    public OrderDto.CreateResponse create(OrderDto.CreateRequest request) {

        var product = productRepository.findById(request.getOrderDetail().getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid ProductId->상품id 없음"));

        // 1. 주문하려는 상품의 재고가 존재하는지 확인
        if (product.getStock() < request.getOrderDetail().getStock()) {
            throw new RuntimeException("Out of Stock");
        }   // RuntimeException -> 자바에서 예외를 나타내는 클래스 중 하나,

        // 2. 멤버 아이디를 찾음
        var member = memberRepository.findById(request.getMemberInfo().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid MemberId->멤버id 없음"));

        // 3. 주문상세정보에 필요한것
        var orderDetail = OrderDetail.builder()
                .price(product.getPrice())
                .quantity(request.getOrderDetail().getStock())
                .product(product)
                .build();

        // 4. 주문상세를 리스트로 만듬
        List<OrderDetail> orderDetails = new ArrayList<>();
        orderDetails.add(orderDetail);

        // 5. 주문에 대한 필요한 정보를 찾음
        var order = Order.builder()
                .member(member)
                .orderAt(LocalDateTime.now())
                .orderStatus(OrderStatus.CREATED)
                .address(
                        Address.builder()
                                .street((request.getDeliveryInfo().getStreet()))
                                .city(request.getDeliveryInfo().getCity())
                                .state(request.getDeliveryInfo().getState())
                                .zipcode(request.getDeliveryInfo().getZipcode())
                                .build())
                .orderDetails(orderDetails)
                .build();

       product.setStock(product.getStock() - request.getOrderDetail().getStock());
        productRepository.save(product);

        orderDetail.changeOrder(order);

        var savedOrder = orderRepository.save(order);

        paymentService.pay(savedOrder.getId());

        return OrderDto.CreateResponse.builder()
                .id(savedOrder.getId())
                .name(savedOrder.getMember().getName())
                .build();
    }

    /**
     * 선택 주문조회
     * @param id 조회할 아이디
     */
    @Transactional(readOnly = true)
    public OrderDto.FindResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                      .orElseThrow(() -> new IllegalArgumentException("Invalid OrderId->id의 주문이 없음"));

        return OrderDto.FindResponse.builder()
                .id(order.getId())
                .memberId(order.getMember().getId())
                .orderAt(order.getOrderAt())
                .address(order.getAddress())
                .orderStatus(order.getOrderStatus())
                .orderDetails(order.getOrderDetails().stream()
                        .map(orderDetail -> OrderDto.OrderDetailDto.builder()
                                .productId(orderDetail.getProduct().getId())
                                .stock(orderDetail.getQuantity())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    /**
     * 전체주문조회
     */
    @Transactional(readOnly = true)
    public List<OrderDto.FindResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();

        return orders.stream()
                .map(order -> OrderDto.FindResponse.builder()
                        .id(order.getId())
                        .memberId(order.getMember().getId())
                        .orderAt(order.getOrderAt())
                        .address(order.getAddress())
                        .orderStatus(order.getOrderStatus())
                        .orderDetails(order.getOrderDetails().stream()
                                .map(orderDetail -> OrderDto.OrderDetailDto.builder()
                                        .productId(orderDetail.getProduct().getId())
                                        .stock(orderDetail.getQuantity())
                                        .build())
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }
}