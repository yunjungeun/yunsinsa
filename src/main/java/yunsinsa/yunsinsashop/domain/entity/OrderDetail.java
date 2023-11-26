package yunsinsa.yunsinsashop.domain.entity;

import lombok.Builder;
import javax.persistence.*;


@Entity
@Table(name = "tb_order_detail")
public class OrderDetail extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name="quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private int price;

    @Builder
    public OrderDetail(Long id, Order order, Product product, int quantity, int price) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public void changeOrder(Order order) {
        this.order = order;
    }
}