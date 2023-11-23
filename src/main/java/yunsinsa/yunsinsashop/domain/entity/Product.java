package yunsinsa.yunsinsashop.domain.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tb_product")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name", nullable=false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    /**
     * FetchType.EAGER = 연관관계 엔티티를 join 을 통해서 한꺼번에 조회해온다.
     *   -> Product 랑 Category 를 한꺼번에 가져옴
     *
     * FetchType.LAZY = 연관관계 엔티티를 실제로 사용하는 시점에 select 쿼리를 날려서 데이터를 가져온다.
     *   -> 1. Product 만 가져오고
     *   -> 2. Category 를 사용하는 시점에 쿼리를 날려서 데이터를 가져온다.
     *
     *   문제!!!
     *   Lazy Option 을 주게 되면, 사용하는 시점마다 쿼리가 날라가기때문에 (N+1) 성능적인 영향이 있다.
     *
     */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id", nullable = false)
    private Category category;

    @Column(name="price", nullable = false)
    private int price;

    @Column(name="stock", nullable = false)
    private int stock;

    public void setStock(int newStock) {
        this.stock = newStock;
    }


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
