package in.sahilkokitkar.moneymanager.ecommerce.service.impl;

import in.sahilkokitkar.moneymanager.ecommerce.dto.ProductSearchRequest;
import in.sahilkokitkar.moneymanager.ecommerce.entity.ProductEntity;
import in.sahilkokitkar.moneymanager.ecommerce.repository.ProductRepository;
import in.sahilkokitkar.moneymanager.ecommerce.service.ProductService;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductEntity createProduct(ProductEntity product) {
        product.setCreatedAt(LocalDateTime.now());
        return productRepository.save(product);
    }

    @Override
    public ProductEntity updateProduct(Long id, ProductEntity product) {
        ProductEntity existing = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        existing.setName(product.getName());
        existing.setBrand(product.getBrand());
        existing.setPrice(product.getPrice());
        existing.setDiscountPrice(product.getDiscountPrice());
        existing.setSizes(product.getSizes());
        existing.setColors(product.getColors());
        existing.setStockQuantity(product.getStockQuantity());
        existing.setImageUrl(product.getImageUrl());
        existing.setDescription(product.getDescription());
        existing.setCategory(product.getCategory());
        return productRepository.save(existing);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<ProductEntity> searchProducts(ProductSearchRequest request) {
        Sort sort = "price_asc".equalsIgnoreCase(request.getSort())
                ? Sort.by("price").ascending()
                : "price_desc".equalsIgnoreCase(request.getSort())
                ? Sort.by("price").descending()
                : Sort.by("createdAt").descending();

        Pageable pageable = PageRequest.of(request.getPage(), request.getSizePage(), sort);

        return productRepository.findAll((root, query, cb) -> {
            var predicates = new ArrayList<Predicate>();
            if (request.getQuery() != null && !request.getQuery().isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + request.getQuery().toLowerCase() + "%"));
            }
            if (request.getCategory() != null && !request.getCategory().isBlank()) {
                predicates.add(cb.equal(cb.lower(root.get("category").get("name")), request.getCategory().toLowerCase()));
            }
            if (request.getBrand() != null && !request.getBrand().isBlank()) {
                predicates.add(cb.equal(cb.lower(root.get("brand")), request.getBrand().toLowerCase()));
            }
            if (request.getMinPrice() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("price"), request.getMinPrice()));
            }
            if (request.getMaxPrice() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("price"), request.getMaxPrice()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }
}
