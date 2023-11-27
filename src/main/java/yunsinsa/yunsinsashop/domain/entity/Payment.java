package yunsinsa.yunsinsashop.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_payment")
public class Payment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="order_id", nullable = false)
    private Order order;

    @Column(name = "payment_at", nullable = false)
    private LocalDateTime paymentAt;

    @Column(name = "amount", nullable = false)
    private int amount;

    /**
     * 결제방법
     */
    @Column(name ="payment_method", length = 50, nullable = false)
    @Enumerated(value = EnumType.STRING)
    private PaymentMethod paymentMethod;

    /**
     * 결제거래 아이디
     */
    @Column(name = "transaction_id", unique = true, length = 100)
    private String transactionId;

    /**
     * 결제상태
     */
    @Column(name = "payment_status", length = 20)
    @Enumerated(value = EnumType.STRING)
    private PaymentStatus paymentStatus;

}