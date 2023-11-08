package yunsinsa.yunsinsashop.domain.repository;

import  org.springframework.data.jpa.repository.JpaRepository;
import yunsinsa.yunsinsashop.domain.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
