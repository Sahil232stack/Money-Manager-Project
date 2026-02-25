package in.sahilkokitkar.moneymanager.ecommerce.service;

import in.sahilkokitkar.moneymanager.ecommerce.dto.ProductSearchRequest;
import in.sahilkokitkar.moneymanager.ecommerce.entity.ProductEntity;
import org.springframework.data.domain.Page;

public interface ProductService {
    ProductEntity createProduct(ProductEntity product);
    ProductEntity updateProduct(Long id, ProductEntity product);
    void deleteProduct(Long id);
    Page<ProductEntity> searchProducts(ProductSearchRequest request);
}
