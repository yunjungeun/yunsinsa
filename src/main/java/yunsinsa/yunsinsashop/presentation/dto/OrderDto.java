package yunsinsa.yunsinsashop.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class OrderDto {


    /**
     *
     *  회원정보: { "회원아이디": 1, .... },
     *  배송정보: { "배송지 정보": "1111" },
     *  결제정보: { "12222" }
     */

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    public static class CreateRequest {
        private MemberInfoDto memberInfo;
        private DeliveryInfoDto deliveryInfo;
        private OrderDetailDto orderDetail;
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    public static class MemberInfoDto {
        private Long id;
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    public static class DeliveryInfoDto {
        private String city;
        private String street;
        private int zipcode;
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    public static class OrderDetailDto {
        private Long productId;
        private int stock;
    }
}
