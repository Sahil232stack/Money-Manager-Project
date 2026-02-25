package in.sahilkokitkar.moneymanager.ecommerce.service.impl;

import in.sahilkokitkar.moneymanager.ecommerce.entity.OrderEntity;
import in.sahilkokitkar.moneymanager.ecommerce.enums.OrderStatus;
import in.sahilkokitkar.moneymanager.ecommerce.repository.OrderRepository;
import in.sahilkokitkar.moneymanager.ecommerce.repository.UserRepository;
import in.sahilkokitkar.moneymanager.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Override
    public OrderEntity placeOrder(Long userId) {
        OrderEntity order = OrderEntity.builder()
                .user(userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found")))
                .status(OrderStatus.PLACED)
                .orderedAt(LocalDateTime.now())
                .build();
        return orderRepository.save(order);
    }

    @Override
    public List<OrderEntity> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }
}
