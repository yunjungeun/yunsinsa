package yunsinsa.yunsinsashop.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDto {

    @Getter
    @Setter
    @Builder
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
    @Builder
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
    @Builder
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
    @Builder
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
