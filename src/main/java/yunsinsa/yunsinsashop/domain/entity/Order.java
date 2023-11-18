package yunsinsa.yunsinsashop.domain.entity;

import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/*
객체 그래프 탐색
그래프 = 관계

-> 객체 관계를 탐색한다.

 */

@Entity
@Table(name = "tb_order")
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long id;


    // 테이블에서 FK 를 가지고 있는 엔티티가 양방향 연관관계에서의 주인이 된다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name="order_at", nullable = false)
    private LocalDateTime orderAt;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name = "order_status", length = 20)
    @Enumerated(value = EnumType.STRING) // db에서 인덱스넘버 0.1.2 로 나타남 -> String 으로 바꿈(CREATED,PROGRESS,COMPLETED)
    private OrderStatus orderStatus;  //주문상태


    @OneToMany(mappedBy = "orderDetail")
    private OrderDetail orderDetail;

    // 연관관계 편의 메서드
//    public void changeMember(Member newMember) {
//        this.member = newMember;
//        newMember.changeOrder(this);
//    }

}
