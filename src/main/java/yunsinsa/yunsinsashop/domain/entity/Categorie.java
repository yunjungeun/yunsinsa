package yunsinsa.yunsinsashop.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.security.PrivateKey;
import java.sql.Timestamp;

@Getter
@Setter
@Table(name = "tb_categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", columnDefinition = "INT")
    private Long id;

    @Column(name="category_name", nullable = false, length = 255)
    private String name;

    @Column(name="created_at", columnDefinition ="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name="updated_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updateAt;

    @Column(name="created_by", columnDefinition="INT")
    private int createdBy;

    @Column(name="updated_by", columnDefinition="INT")
    private int updatedBy;

}
