package in.sahilkokitkar.moneymanager.ecommerce.repository;

import in.sahilkokitkar.moneymanager.ecommerce.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
