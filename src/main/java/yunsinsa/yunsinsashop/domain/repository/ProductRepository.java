package yunsinsa.yunsinsashop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yunsinsa.yunsinsashop.domain.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
