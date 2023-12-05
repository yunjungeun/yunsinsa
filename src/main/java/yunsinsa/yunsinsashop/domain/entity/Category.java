package yunsinsa.yunsinsashop.domain.entity;

import lombok.Getter;
import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "tb_category")
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(name="category_name", nullable = false, length = 255)
    private String name;

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Product> products;
}