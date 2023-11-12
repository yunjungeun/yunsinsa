package yunsinsa.yunsinsashop.domain.repository;

import  org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yunsinsa.yunsinsashop.domain.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
