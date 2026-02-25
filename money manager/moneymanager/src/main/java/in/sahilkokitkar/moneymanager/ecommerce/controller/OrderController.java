package in.sahilkokitkar.moneymanager.ecommerce.controller;

import in.sahilkokitkar.moneymanager.ecommerce.entity.OrderEntity;
import in.sahilkokitkar.moneymanager.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ecommerce/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/checkout/{userId}")
    public OrderEntity placeOrder(@PathVariable Long userId) {
        return orderService.placeOrder(userId);
    }

    @GetMapping("/user/{userId}")
    public List<OrderEntity> userOrders(@PathVariable Long userId) {
        return orderService.getOrdersByUser(userId);
    }

    @GetMapping("/admin/all")
    public List<OrderEntity> allOrders() {
        return orderService.getAllOrders();
    }
}
