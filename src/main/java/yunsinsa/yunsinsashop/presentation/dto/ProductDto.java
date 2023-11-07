package yunsinsa.yunsinsashop.presentation.dto;

import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDto {

    // 사용하는 필드가 비슷하다고 해서 객체 하나로 처리하는 것보다 -> 요청마다 dto 도 나누는게 좋음
    // nested class 를 활용


    @Getter
    @Setter
    @AllArgsConstructor
    public static class CreateRequest {
        private String name;
        private String description;
        private Long categoryId;
        private int price;
        private int stock;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class UpdateRequest {
        private Long id;
        private String name;
        private String description;
        private Long categoryId;
        private int price;
        private int stock;
    }
    @Getter
    @Setter
    @AllArgsConstructor
    public static class FindResponse {
        private Long id;
        private String name;
        private String description;
        private Long categoryId;
        private int price;
        private int stock;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class CreateResponse {
        private Long id;
        private String name;
        private String description;
        private Long categoryId;
        private int price;
        private int stock;

    }
}
