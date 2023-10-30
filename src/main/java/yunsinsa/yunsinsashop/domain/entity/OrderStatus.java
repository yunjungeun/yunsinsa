package yunsinsa.yunsinsashop.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// "변동의 거의 없는" = 자주 변동이 일어나면 안됨
// 상수 집합
@Getter
@RequiredArgsConstructor
public enum OrderStatus {
    CREATED("주문 전"),PROGRESS("주문 중"),COMPLETED("주문완료");

    private final String description;
}
