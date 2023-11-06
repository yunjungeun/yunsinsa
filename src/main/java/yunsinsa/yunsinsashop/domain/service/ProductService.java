package yunsinsa.yunsinsashop.domain.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yunsinsa.yunsinsashop.domain.entity.Category;
import yunsinsa.yunsinsashop.domain.entity.Product;
import yunsinsa.yunsinsashop.domain.repository.CategoryRepository;
import yunsinsa.yunsinsashop.domain.repository.ProductRepository;
import yunsinsa.yunsinsashop.presentation.dto.ProductDto;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    // 상품 등록
    public ProductDto.CreateResponse createProduct(ProductDto.CreateRequest request) {
        //카테고리 불러옴 =  카테고리 (카테고리아이디).는 필수로 존재해야함(상품등록 시!!)
        Category category = categoryRepository.findById(request.getCategoryId())
                //  필수로 존재할때 씀 -> 없을때 경고메시지
                .orElseThrow(() -> new IllegalArgumentException("카테고리가 존재하지 않습니다."));

        // Dto -> Entity
        Product newProduct = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .stock(request.getStock())
                .category(category)
                .build();

        Product savedProduct = productRepository.save(newProduct);

        // Entity -> Dto
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

    // 상품 조회

    public ProductDto findProduct(Long id) {
        // 1. id 로 엔티티 조회(repository 로 db 조회) -> 데이터가 없으면 에러
     Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));

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

    // 모든 상품 조회
    public List<Product> findAllProducts() {

        return productRepository.findAll();
    }

     // 상품 수정
     public void updateProduct(ProductDto.UpdateRequest request) {
         // 1. id 로 상품 조회
         Product product = productRepository.findById(request.getId())
                 .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));

         // 2. 카테고리 조회
         Category category = categoryRepository.findById(request.getCategoryId())
                 //  필수로 존재할때 씀 -> 없을때 경고메시지
                 .orElseThrow(() -> new IllegalArgumentException("카테고리가 존재하지 않습니다."));

         // 3. request 에 들어있는 정보를 활용해서 entity 를 업데이트  -> 변경중
         product.change(request.getName(), request.getDescription(), category, request.getPrice(), request.getStock());

         // 4. 변경된 값을 저장해야함.

   }


    // 상품 삭제
    public void deleteProduct(Long id) {
        Product product = findProduct(id);
        productRepository.delete(product);
    }
}