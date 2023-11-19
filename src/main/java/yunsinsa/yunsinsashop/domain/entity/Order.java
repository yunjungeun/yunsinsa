package yunsinsa.yunsinsashop.domain.entity;

import lombok.Builder;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

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

    // 파란색 셔츠 외 1건
//    @Transient  //->  해당 요소가 일시적이거나 순간적인 상태,해당 필드가 데이터베이스에 저장되지 않아야 한다는 것을 나타냄
//    private String orderName;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name = "order_status", length = 20)
    @Enumerated(value = EnumType.STRING) // db에서 인덱스넘버 0.1.2 로 나타남 -> String 으로 바꿈(CREATED,PROGRESS,COMPLETED)
    private OrderStatus orderStatus;  //주문상태


    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    // 연관관계 편의 메서드
//    public void changeMember(Member newMember) {
//        this.member = newMember;
//        newMember.changeOrder(this);
//    }

    @Builder
    public Order(Long id, Member member, LocalDateTime orderAt, String address, OrderStatus orderStatus, List<OrderDetail> orderDetails) {
        this.id = id;
        this.member = member;
        this.orderAt = orderAt;
        this.address = address;
        this.orderStatus = orderStatus;
        this.orderDetails = orderDetails;
    }
}
