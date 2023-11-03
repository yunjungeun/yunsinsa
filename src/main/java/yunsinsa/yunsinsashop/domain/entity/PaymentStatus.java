package yunsinsa.yunsinsashop.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Before;

@Getter
@RequiredArgsConstructor
public enum PaymentStatus {
    // BEFORE_PAYMENT, PROGRESS, COMPLETED
   BEFORE_PAYMENT("결제 전"),PROGRESS("결제중"),COMPLETED("결제완료");
    private final String description;  // 서술 기능: 주석 대신 유용하게 쓰인다!!!!!!!
}
