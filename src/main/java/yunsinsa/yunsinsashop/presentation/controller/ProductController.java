package yunsinsa.yunsinsashop.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yunsinsa.yunsinsashop.domain.service.ProductService;
import yunsinsa.yunsinsashop.presentation.dto.ProductDto;

import java.util.List;

@RequiredArgsConstructor // final 이 붙어있거나 @Nonnull 어노테이션이 붙어 있는 필드를 = Required Arguments
@RestController
@RequestMapping("/products") // 주소값은 보통 뒤에 s를 붙힌다
public class ProductController {

    private final ProductService productService;

//    @Autowired
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }

    // 상품 등록
    @PostMapping
    public ProductDto.CreateResponse createProduct(@RequestBody ProductDto.CreateRequest request) {
        return productService.createProduct(request);
    }

    // 상품 조회
    @GetMapping("/{id}")
    public ProductDto.FindResponse findProduct(@PathVariable Long id) {
        return productService.findProduct(id);
    }

    // 모든 상품 조회
    @GetMapping("/all") // TODO all 자체가 필요 없음
    public List<ProductDto.FindResponse> findAllProducts() {
        return productService.findAllProducts();
    }

    // 상품 수정 -전체수정일때 매핑 / 서비스와 같아야함
    @PutMapping("/update")
    public void updateProduct(@RequestBody ProductDto.UpdateRequest request) {
        productService.updateProduct(request);
    }

    // 상품 삭제
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}