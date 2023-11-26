package yunsinsa.yunsinsashop.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yunsinsa.yunsinsashop.domain.entity.Category;
import yunsinsa.yunsinsashop.domain.repository.CategoryRepository;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    // TODO 테스트 용으로 만든 코드들은 제거
    /*public void findAllCategory() {
        var categories = categoryRepository.findAll();

        // iter -> enchanced for 문을 작성해줌
        System.out.println(categories.size());
        for (Category category : categories) {
            var productIds = category.getProducts().stream()
                    .map(it -> it.getId())
                    .collect(Collectors.toList());
        }

        System.out.println("11111111");
    }*/
}
