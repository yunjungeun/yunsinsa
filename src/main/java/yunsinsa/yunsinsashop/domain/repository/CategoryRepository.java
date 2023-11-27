package yunsinsa.yunsinsashop.domain.repository;

import  org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import yunsinsa.yunsinsashop.domain.entity.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

   @Query("select c from Category c join fetch c.products")
   List<Category> findAllCategories();
}