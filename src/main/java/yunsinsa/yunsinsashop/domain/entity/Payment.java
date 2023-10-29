package yunsinsa.yunsinsashop.domain.entity;

import lombok.Data;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "tb_payment")
public class Payment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id 생성을 db 로 위임 :자동 증가(primary key) 역할
    @Column(name = "payment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="order_id", nullable = false)
    private Order order;

    @Column(name = "payment_at", nullable = false)
    private LocalDateTime paymentAt;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name ="payment_method", length = 50, nullable = false) //결제방법
    @Enumerated(value = EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column(name = "transaction_id", unique = true, length = 100)
    private String transactionId;

    @Column(name = "payment_status", length = 20)
    @Enumerated(value = EnumType.STRING)
    private PaymentStatus paymentStatus;

}
