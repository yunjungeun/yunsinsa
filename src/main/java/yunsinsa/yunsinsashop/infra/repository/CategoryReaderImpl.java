
package yunsinsa.yunsinsashop.infra.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yunsinsa.yunsinsashop.domain.entity.Category;
import yunsinsa.yunsinsashop.domain.repository.CategoryReader;
import yunsinsa.yunsinsashop.domain.repository.CategoryRepository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CategoryReaderImpl implements CategoryReader {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAllCategories();
    }
}


