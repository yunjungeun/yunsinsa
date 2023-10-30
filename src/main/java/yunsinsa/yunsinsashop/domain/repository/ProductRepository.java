package yunsinsa.yunsinsashop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yunsinsa.yunsinsashop.domain.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
