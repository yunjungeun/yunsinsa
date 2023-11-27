package yunsinsa.yunsinsashop.domain.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Table(name = "tb_order")
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name="order_at", nullable = false)
    private LocalDateTime orderAt;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name = "order_status", length = 20)
    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    @Builder
    public Order(Long id, Member member, LocalDateTime orderAt, String address,
                 OrderStatus orderStatus, List<OrderDetail> orderDetails) {
        this.id = id;
        this.member = member;
        this.orderAt = orderAt;
        this.address = address;
        this.orderStatus = orderStatus;
        this.orderDetails = orderDetails;
    }
}