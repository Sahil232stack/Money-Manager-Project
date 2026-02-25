package in.sahilkokitkar.moneymanager.ecommerce.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductSearchRequest {
    private String query;
    private String category;
    private String brand;
    private String size;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private String sort;
    private Integer page = 0;
    private Integer sizePage = 12;
}
