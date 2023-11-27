package yunsinsa.yunsinsashop.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yunsinsa.yunsinsashop.domain.entity.Category;
import yunsinsa.yunsinsashop.domain.entity.Product;
import yunsinsa.yunsinsashop.domain.repository.CategoryRepository;
import yunsinsa.yunsinsashop.domain.repository.ProductRepository;
import yunsinsa.yunsinsashop.presentation.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    /**
     * 상품 등록
     */
    @Transactional
    public ProductDto.CreateResponse createProduct(ProductDto.CreateRequest request) {

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category Not Found"));

        Product newProduct = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .stock(request.getStock())
                .category(category)
                .build();

        Product savedProduct = productRepository.save(newProduct);

        ProductDto.CreateResponse response = ProductDto.CreateResponse.builder()
                .id(savedProduct.getId())
                .name(savedProduct.getName())
                .description(savedProduct.getDescription())
                .price(savedProduct.getPrice())
                .stock(savedProduct.getStock())
                .categoryId(savedProduct.getCategory().getId())
                .build();

        return response;
    }

    /**
     * 상품 조회
     * @param id 조회할 아이디
     */
    public ProductDto.FindResponse findProduct(Long id) {
        // 1. id 로 엔티티 조회(repository 로 db 조회) -> 데이터가 없으면 에러
     Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not find.."));

        // 2. 조회된 엔티티를 -> dto 로 변환
     ProductDto.FindResponse response = ProductDto.FindResponse.builder()
        .id(product.getId())
        .name(product.getName())
        .description(product.getDescription())
        .price(product.getPrice())
        .stock(product.getStock())
        .categoryId(product.getCategory().getId())
        .build();

        // 3. 변환된 dto 를 반환
        return response;
    }

    /**
     * 모든 상품 조회
     */
    public List<ProductDto.FindResponse> findAllProducts() {

        List<Product> products = productRepository.findAll();

        List<ProductDto.FindResponse> responses = new ArrayList<>();

        for(Product product : products){
            ProductDto.FindResponse response = ProductDto.FindResponse.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .stock(product.getStock())
                    .categoryId(product.getCategory().getId())
                    .build();
            responses.add(response);
        }
        return responses;
    }

    /**
     * 상품 수정
     */
     @Transactional
     public void updateProduct(ProductDto.UpdateRequest request) {

         Product product = productRepository.findById(request.getId())
                 .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));


         Category category = categoryRepository.findById(request.getCategoryId())
                 .orElseThrow(() -> new IllegalArgumentException("카테고리가 존재하지 않습니다."));

         product.change(request.getName(),
                 request.getDescription(),
                 category,
                 request.getPrice(),
                 request.getStock());
                }

    /**
     * 상품 삭제
      * @param id 삭제할 상품의 아이디
     */
    @Transactional
    public void deleteProduct(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("제품이 존재하지 않습니다."));

        productRepository.delete(product);
    }
}