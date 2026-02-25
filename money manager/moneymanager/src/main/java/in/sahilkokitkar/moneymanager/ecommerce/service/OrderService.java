package in.sahilkokitkar.moneymanager.ecommerce.service;

import in.sahilkokitkar.moneymanager.ecommerce.entity.OrderEntity;

import java.util.List;

public interface OrderService {
    OrderEntity placeOrder(Long userId);
    List<OrderEntity> getOrdersByUser(Long userId);
    List<OrderEntity> getAllOrders();
}
