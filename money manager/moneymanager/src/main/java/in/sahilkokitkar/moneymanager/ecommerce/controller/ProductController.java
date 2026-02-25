package in.sahilkokitkar.moneymanager.ecommerce.controller;

import in.sahilkokitkar.moneymanager.ecommerce.dto.ProductSearchRequest;
import in.sahilkokitkar.moneymanager.ecommerce.entity.ProductEntity;
import in.sahilkokitkar.moneymanager.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ecommerce/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/search")
    public Page<ProductEntity> search(@RequestBody ProductSearchRequest request) {
        return productService.searchProducts(request);
    }

    @PostMapping("/admin")
    public ProductEntity create(@RequestBody ProductEntity product) {
        return productService.createProduct(product);
    }

    @PutMapping("/admin/{id}")
    public ProductEntity update(@PathVariable Long id, @RequestBody ProductEntity product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/admin/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
