package yunsinsa.yunsinsashop.domain.entity;


import lombok.Setter;

import javax.persistence.*;

@Setter
@Entity
@Table(name = "tb_member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id 생성을 db 로 위임
    @Column(name = "member_id", columnDefinition = "일련번호")
    private Long id;

    @Column(name = "member_name", columnDefinition = "회원 이름")
    private String name;
}
