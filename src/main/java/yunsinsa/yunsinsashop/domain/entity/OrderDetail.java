package yunsinsa.yunsinsashop.domain.entity;

import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
@Setter
@Entity
@Table(name = "tb_order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id 생성을 db 로 위임 :자동 증가(primary key) 역할
    @Column(name = "order_detail_id", columnDefinition = "INT")
    private Long id;

    @Column(name="order_id", columnDefinition = "INT")
    private int order_id;

    @Column(name="product_id", columnDefinition = "INT")
    private int product_id;

    @Column(name="quantity", columnDefinition = "INT", nullable = false)
    private int quantity;

    @Column(name = "price", columnDefinition = "INT", nullable = false)
    private int price;

    @Column(name="created_at", columnDefinition ="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name="updated_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updateAt;

    @Column(name="created_by", columnDefinition="INT")
    private int createdBy;

    @Column(name="updated_by", columnDefinition="INT")
    private int updatedBy;
}
