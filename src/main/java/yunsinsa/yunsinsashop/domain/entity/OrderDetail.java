package yunsinsa.yunsinsashop.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "tb_order_detail")
public class OrderDetail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;

    @Getter
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Getter
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

        // null 발생 해결을 위한 메서드 생성
    public void setOrder(Order order) {
        if (this.order != null) {
            this.order.getOrderDetails().remove(this);
        }
        this.order = order;
        if (order != null) {
            order.getOrderDetails().add(this);
        }
    }
}