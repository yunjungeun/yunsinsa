package yunsinsa.yunsinsashop.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PaymentMethod {

    ACCOUNT_TRANSFER("계좌 이체"), CARD("카드");

    private final String description;
}
