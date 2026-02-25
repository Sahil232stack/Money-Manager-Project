package in.sahilkokitkar.moneymanager.ecommerce.service;

import in.sahilkokitkar.moneymanager.ecommerce.dto.AuthRequest;
import in.sahilkokitkar.moneymanager.ecommerce.dto.AuthResponse;
import in.sahilkokitkar.moneymanager.ecommerce.entity.UserEntity;

public interface AuthService {
    UserEntity register(UserEntity user);
    AuthResponse login(AuthRequest request);
}
