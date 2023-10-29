package yunsinsa.yunsinsashop.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PaymentMethod {

    //결제방법: 계좌이체, 카드
    // accountTransfer , card
    ACCOUNT_TRANSFER("계좌 이체"), CARD("카드"),
    ;

    private final String description;

//   @RequiredArgsConstructor
//    PaymentMethod(String description) {
//        this.description = description;
//    }
}
