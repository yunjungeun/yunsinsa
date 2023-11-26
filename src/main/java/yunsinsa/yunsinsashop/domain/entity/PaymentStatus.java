package yunsinsa.yunsinsashop.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentStatus {

   BEFORE_PAYMENT("결제 전"),
   PROGRESS("결제중"),
   COMPLETED("결제완료");

    private final String description;
}