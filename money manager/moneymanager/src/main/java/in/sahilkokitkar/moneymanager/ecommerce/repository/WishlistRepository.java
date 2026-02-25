package in.sahilkokitkar.moneymanager.ecommerce.repository;

import in.sahilkokitkar.moneymanager.ecommerce.entity.WishlistItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistRepository extends JpaRepository<WishlistItemEntity, Long> {
    List<WishlistItemEntity> findByUserId(Long userId);
}
