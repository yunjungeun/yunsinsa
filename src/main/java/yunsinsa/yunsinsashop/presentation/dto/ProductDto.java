package yunsinsa.yunsinsashop.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Long categoryId;
    private int price;
    private int stock;

}
