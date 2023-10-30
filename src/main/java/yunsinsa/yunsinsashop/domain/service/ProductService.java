package yunsinsa.yunsinsashop.domain.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yunsinsa.yunsinsashop.domain.entity.Product;
import yunsinsa.yunsinsashop.domain.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 상품 등록
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // 상품 조회
    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));
    }

    // 모든 상품 조회
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 상품 수정
   /* public Product updateProduct(Long id, Product product) {
        Product existingProduct = getProduct(id);  // 기존 엔티티 불러오기
        existingProduct.setName(product.getName());  //이름 업데이트
        existingProduct.setDescription(product.getDescription());   //설명 업뎃
        existingProduct.setCategory(product.getCategory());  // 카테고리 업뎃
        existingProduct.setPrice(product.getPrice());  //가격 업뎃
        existingProduct.setStock(product.getStock());   //재고 업뎃

        return productRepository.save(existingProduct);  // 업뎃한거 저장
        }
    */

    // 상품 삭제
    public void deleteProduct(Long id) {
        Product product = getProduct(id);
        productRepository.delete(product);
    }
}