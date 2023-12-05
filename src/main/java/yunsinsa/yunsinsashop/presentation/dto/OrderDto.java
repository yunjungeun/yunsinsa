package yunsinsa.yunsinsashop.presentation.dto;

import lombok.*;
import yunsinsa.yunsinsashop.domain.entity.OrderStatus;
import yunsinsa.yunsinsashop.domain.model.Address;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private MemberDto memberInfo;
    private LocalDateTime orderAt;
    private OrderDto.DeliveryInfoDto deliveryInfo;
    private OrderStatus orderStatus;
    private List<OrderDetailDto> orderDetails;



    /**
     *  Dto 구성 -
     *  회원정보: { "회원아이디": 1, .... },
     *  배송정보: { "배송지 정보": "1111" },
     *  결제정보: { "12222" }
     */

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateRequest {
        private MemberInfoDto memberInfo;
        private Long memberId;
        private DeliveryInfoDto deliveryInfo;
        private OrderDetailDto orderDetail;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberInfoDto {
        private Long id;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DeliveryInfoDto {
        private String city;
        private String street;
        private String state;
        private int zipcode;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderDetailDto {
        private Long productId;
        private int stock;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateResponse {
        private Long id;
        private String name;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FindResponse {
        private Long id;
        private Long memberId;
        private LocalDateTime orderAt;
        private Address address;
        private OrderStatus orderStatus;
        private List<OrderDetailDto> orderDetails;
    }
}