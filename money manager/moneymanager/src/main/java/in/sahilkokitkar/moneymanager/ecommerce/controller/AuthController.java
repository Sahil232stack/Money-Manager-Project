package in.sahilkokitkar.moneymanager.ecommerce.controller;

import in.sahilkokitkar.moneymanager.ecommerce.dto.AuthRequest;
import in.sahilkokitkar.moneymanager.ecommerce.dto.AuthResponse;
import in.sahilkokitkar.moneymanager.ecommerce.entity.UserEntity;
import in.sahilkokitkar.moneymanager.ecommerce.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ecommerce/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public UserEntity register(@RequestBody UserEntity user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return authService.login(request);
    }
}
