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
    private final PaymentService paymentService;
    private final MemberRepository memberRepository;

    /*  동시성 문제
        2개의 요청이 동시에 왔다고 가정
        첫번째 요청을 tx1, 두 번째 요청을 tx2

        tx1 과 tx2 가 OrderService.create 메서드에 진입

        tx1이 아주 미세하게 빠름

        둘이 동시에 product 를 조회하면 stock 값이 e.g 10 로 같음
        tx1 의 request.getOrderDetail().getStock() 값은 10 이고 tx2 의 request.getOrderDetail().getStock() 값은 2

        tx1 은 정상적으로처리됨 -> product 의 재고는 0개가 됨
        tx2 원래는 정상적으로 처리되면 안되는데 -> 처리가 됨 -> 데이터에 대한 정합성 문제가 발생
     */

    /*
        동시성을 해결하는 방법
        synchronized -> 가장 간편하게 해결할 수 있음 -> 단점은 성능이 안 좋다. -> 성능이 중요하지 않은 서비스라고 하면 써도 크게 상관 없음

        lock -> 성능이 중요한 서비스에서 자주 사용되는 기술
          - 비관락 -> db select ...  for update -> db 에 lock 을 거는 기술 -> 단점이 성능 문제가 있음
             -> 무조건 성공해야 하는 경우
          - 낙관락
             -> version 컬럼을 두는 것
             -> 0부터 시작
             -> productRepository.findById 조회하는 시점에서 tx1, tx2 는 모두 0
             -> tx1 이 먼저 product stock 을 업데이트 -> version 도 같이 업데이트 됨 -> version 1
             -> tx2 가 업데이트 update stock=1 where version = 0 and productId = 1 -> 업데이트 실패
          - 분산락
            -> 비지니스 로직에 lock 을 거는데 redis 를 사용
            -> lettuce, redisson 이라는 라이브러리들을 주로 사용
            -> lettuce 는 spinlock, redisson 은 pub/sub 이라는 매커니즘을 사용, 성능상 redisson 이 좋음
     */

    @Transactional     //주문생성 및 재고확인
    public void create(OrderDto.CreateRequest request) {
        var product = productRepository.findById(request.getOrderDetail().getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid ProductId"));

        // 1. 주문하려는 상품의 재고가 존재하는지 확인
        if (product.getStock() < request.getOrderDetail().getStock()) {
            throw new RuntimeException("Out of Stock");
        }   // RuntimeException -> 자바에서 예외를 나타내는 클래스 중 하나,

        // 2. 멤버 아이디를 찾음
        var member = memberRepository.findById(request.getMemberInfo().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid MemberId/멤버id 없음"));

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
        orderDetail.changeOrder(order);

        // 레파짓토리에 주문을 저장함
        var savedOrder = orderRepository.save(order);

        // 결제
        paymentService.pay(savedOrder.getId());
    }

    @Transactional(readOnly = true)
    public Order getOrderById(Long id) {  // 아이디 선택하여 조회
        return orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid OrderId/id의 주문이 없음"));
    } // id의 주문을 디비에서 못찾으면 orElseThrow 메서드는 예외를 발생시킨다(메시지와 함께!!!)

    @Transactional(readOnly = true) // 전체주문조회
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
