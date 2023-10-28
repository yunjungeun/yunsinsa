package yunsinsa.yunsinsashop.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id", columnDefinition = "INT")
    private Long id;

    @Column(name = "member_id", columnDefinition = "INT")
    private int memberId;
    @Column(name="order_at", nullable = false, columnDefinition="DATETIME")
    private LocalDateTime orderAt;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name="created_at", columnDefinition ="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name="updated_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updateAt;

    @Column(name="created_by", columnDefinition="INT")
    private int createdBy;

    @Column(name="updated_by", columnDefinition="INT")
    private int updatedBy;

    @Column(name = "order_status", length = 20)
    private String orderStatus;

}
