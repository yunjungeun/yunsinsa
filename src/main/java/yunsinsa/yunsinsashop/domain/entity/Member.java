package yunsinsa.yunsinsashop.domain.entity;

import lombok.Builder;
import lombok.Getter;
import yunsinsa.yunsinsashop.domain.model.Address;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "tb_member")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_name", length = 255, nullable = false)
    private String name;

    @Column(name = "email", length = 255, nullable = false)
    private String email;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @Column(name = "password")
    private String password;

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
