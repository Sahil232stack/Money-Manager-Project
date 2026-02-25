package in.sahilkokitkar.moneymanager.ecommerce.repository;

import in.sahilkokitkar.moneymanager.ecommerce.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<CartEntity, Long> {
    Optional<CartEntity> findByUserId(Long userId);
}
