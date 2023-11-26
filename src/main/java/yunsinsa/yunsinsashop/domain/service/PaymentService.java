package yunsinsa.yunsinsashop.domain.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    // 결제에 필요한 정보를 받아야 함
    public void pay(Long orderId) {
        // Order order = orderRepository.findById(orderId)  // 생성된 주문에 대한 정보를 가져옴
        // order.getTotalAmount() -> 주문 총 금액에 대한 값을 가져와야 함
        // Pg 사를 호출하고
        // Pg 사로부터 성공적인 응답을 받으면
        // paymentRespository.save(결제 내역을 저장);
    }
}
