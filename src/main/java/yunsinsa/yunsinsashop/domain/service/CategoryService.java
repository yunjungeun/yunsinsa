package yunsinsa.yunsinsashop.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yunsinsa.yunsinsashop.domain.repository.CategoryRepository;


@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void findAllCategory() {
        var categories = categoryRepository.findAll();
    }
}
