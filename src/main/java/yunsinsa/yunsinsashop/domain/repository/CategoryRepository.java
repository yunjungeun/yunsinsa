package yunsinsa.yunsinsashop.domain.repository;

import  org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import yunsinsa.yunsinsashop.domain.entity.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    // join fetch 를 사용하면 INNER JOIN 을 통해서 데이터를 한 꺼번에 가져온다.
    @Query("select c from Category c join fetch c.products")
    public List<Category> findAllCategories();
}
