
package yunsinsa.yunsinsashop.domain.repository;

import yunsinsa.yunsinsashop.domain.entity.Category;

import java.util.List;

public interface CategoryReader {
    List<Category> findAllCategories();
}