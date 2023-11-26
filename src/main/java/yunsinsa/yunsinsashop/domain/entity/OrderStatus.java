package yunsinsa.yunsinsashop.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {
    CREATED("주문 생성"),
    COMPLETED("주문 완료");

    private final String description;
}
