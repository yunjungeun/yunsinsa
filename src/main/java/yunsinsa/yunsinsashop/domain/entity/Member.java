package yunsinsa.yunsinsashop.domain.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import yunsinsa.yunsinsashop.domain.model.Address;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "tb_member")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id 생성을 db 로 위임 :자동 증가(primary key) 역할
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_name", length = 255, nullable = false)
    private String name;

    @Column(name = "email", length = 255, nullable = false)
    private String email;

    @Embedded
    private Address address;

    // 처음에는 무조건 단방향으로 설계를 하되, 나중에 필요로하면 양방향 연관관계를 설정
    // 연관관계 주인이 아닌 곳(@OneToMany)에는 mappedBy 로 연관관계 주인을 지정
//    @OneToMany(mappedBy = "member")
//    private List<Order> orders = new ArrayList<>();

    @Column(name="password")
    private String password;

//    public void changeOrder(Order order) {
//        // order 를 교체하는 로직
//    }

    @Builder
    public Member(String name, String email,String password, Address address){
        this.name=name;
        this.email=email;
        this.password=password;
        this.address=address;
    }

    public void change(String name, String email, String password, Address address){
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }
}
