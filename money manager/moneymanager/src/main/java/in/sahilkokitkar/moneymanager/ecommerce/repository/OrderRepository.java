package in.sahilkokitkar.moneymanager.ecommerce.repository;

import in.sahilkokitkar.moneymanager.ecommerce.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findByUserId(Long userId);
}
