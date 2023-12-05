package yunsinsa.yunsinsashop.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yunsinsa.yunsinsashop.domain.service.ProductService;
import yunsinsa.yunsinsashop.presentation.dto.ProductDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    /**
     * 상품 생성
     *
     */
    @PostMapping
    public ProductDto.CreateResponse createProduct(@RequestBody ProductDto.CreateRequest request) {
        return productService.createProduct(request);
    }

    /**
     * 상품 조회
     * @param id 조회할 상품 아이디
     */
    @GetMapping("/{id}")
    public ProductDto.FindResponse findProduct(@PathVariable Long id) {
        return productService.findProduct(id);
    }

    /**
     * 모든 상품 조회
     */
    @GetMapping("/all")
    public List<ProductDto.FindResponse> findAllProducts() {
        return productService.findAllProducts();
    }

    /**
     * 상품 수정
     */
    @PutMapping("/update")
    public void updateProduct(@RequestBody ProductDto.UpdateRequest request) {
        productService.updateProduct(request);
    }

    /**
     * 상품 삭제
     * @param id 삭제할 상품의 아이디
     */
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}