package yunsinsa.yunsinsashop.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class OrderDto {


    /**
     *  Dto 구성 -
     *  회원정보: { "회원아이디": 1, .... },
     *  배송정보: { "배송지 정보": "1111" },
     *  결제정보: { "12222" }
     */

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    public static class CreateRequest {  //오너디티오: 3가지 구성
        private MemberInfoDto memberInfo;
        private DeliveryInfoDto deliveryInfo;
        private OrderDetailDto orderDetail;
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    public static class MemberInfoDto { //주문자 정보
        private Long id;
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    public static class DeliveryInfoDto {  //주문정보
        private String city;
        private String street;
        private int zipcode;
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    public static class OrderDetailDto { // 주문상세 정보
        private Long productId;
        private int stock;
    }
}
