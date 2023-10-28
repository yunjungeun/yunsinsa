package yunsinsa.yunsinsashop.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Table(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", columnDefinition = "INT")
    private Long id;

    @Column(name = "product_name", nullable=false)
    private String name;

    @Column(name="description", columnDefinition="TEXT")
    private String description;

    @Column(name="category_id", columnDefinition = "INT", nullable = false)
    private int categoryId;

    @Column(name="price", columnDefinition = "INT", nullable = false)
    private int price;

    @Column(name="stock",columnDefinition = "INT", nullable = false)
    private int stock;

    @Column(name="created_at", columnDefinition ="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name="updated_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updateAt;

    @Column(name="created_by", columnDefinition="INT")
    private int createdBy;

    @Column(name="updated_by", columnDefinition="INT")
    private int updatedBy;
}
