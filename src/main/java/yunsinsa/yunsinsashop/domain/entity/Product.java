package yunsinsa.yunsinsashop.domain.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Table(name = "tb_product")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name", nullable=false)
    private String name;

    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private Category category;

    @Column(name="price", nullable = false)
    private int price;

    @Column(name="stock", nullable = false)
    private int stock;

    @Builder
    public Product(Long id, String name, String description, Category category, int price, int stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public void change(String name, String description, Category category, int price, int stock) {  //업뎃
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }
}
