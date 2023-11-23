package yunsinsa.yunsinsashop.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
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

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
   // private final PaymentService paymentService;
    private final MemberRepository memberRepository;

    @Transactional
    public void create(OrderDto.CreateRequest request) {  //주문생성 및 재고확인
        var product = productRepository.findById(request.getOrderDetail().getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid ProductId"));

        // 주문하려는 상품의 재고가 존재하는지 확인
        if (product.getStock() < request.getOrderDetail().getStock()) {
            throw new RuntimeException("Out of Stock");
        }

        var member = memberRepository.findById(request.getMemberInfo().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid MemberId"));

        var orderDetail = OrderDetail.builder()
                .price(product.getPrice())
                .quantity(request.getOrderDetail().getStock())
                .product(product)
                .build();

        List<OrderDetail> orderDetails = new ArrayList<>();
        orderDetails.add(orderDetail);

        var order = Order.builder()
                .member(member)
                .orderAt(LocalDateTime.now())
                .orderStatus(OrderStatus.COMPLETED)
                .address(Address.builder()
                        .city(request.getDeliveryInfo().getCity())
                        .state(request.getDeliveryInfo().getStreet())
                        .zipcode(request.getDeliveryInfo().getZipcode())
                        .build().toString())
                .orderDetails(orderDetails)
                .build();

        product.setStock(product.getStock() - request.getOrderDetail().getStock());
        productRepository.save(product); //주문될 때마다 해당 상품의 재고가 감소!!

        // 양방향 연관관계에 따라서 order 도 같이 세팅
        orderDetail.setOrder(order);

        var savedOrder = orderRepository.save(order);


        // 결제
        //paymentService.createPayment(결제에 필요한 정보를 전달);
    }



    @Transactional(readOnly = true)
    public Order getOrderById(Long id) {  // 아이디 선택하여 조회
        return orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid OrderId"));
    }

    @Transactional(readOnly = true) // 전체주문조회
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

}
