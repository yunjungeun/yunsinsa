package yunsinsa.yunsinsashop.domain.entity;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Entity
@Table(name = "tb_payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id 생성을 db 로 위임 :자동 증가(primary key) 역할
    @Column(name = "payment_id", columnDefinition = "INT")
    private Long id;

    @Column(name="order_id", columnDefinition = "INT", nullable = false)
    private int order_id;

    @Column(name = "payment_at", columnDefinition = "DATE", nullable = false)
    private LocalDateTime paymentAt;

    @Column(name = "amount", columnDefinition = "INT", nullable = false)
    private int amount;

    @Column(name ="payment_method", length = 50, nullable = false)
    private String payment_method;

    @Column(name = "transaction_id", unique = true, length = 100)
    private String transactionId;

    @Column(name="created_at", columnDefinition ="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name="updated_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updateAt;

    @Column(name="created_by", columnDefinition="INT")
    private int createdBy;

    @Column(name="updated_by", columnDefinition="INT")
    private int updatedBy;

    @Column(name = "payment_status", length = 20)
    private String paymentStatus;

}
