package in.sahilkokitkar.moneymanager.ecommerce.service.impl;

import in.sahilkokitkar.moneymanager.ecommerce.dto.AuthRequest;
import in.sahilkokitkar.moneymanager.ecommerce.dto.AuthResponse;
import in.sahilkokitkar.moneymanager.ecommerce.entity.UserEntity;
import in.sahilkokitkar.moneymanager.ecommerce.enums.Role;
import in.sahilkokitkar.moneymanager.ecommerce.repository.UserRepository;
import in.sahilkokitkar.moneymanager.ecommerce.security.JwtTokenProvider;
import in.sahilkokitkar.moneymanager.ecommerce.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public UserEntity register(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRole() == null) {
            user.setRole(Role.ROLE_USER);
        }
        return userRepository.save(user);
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        String token = jwtTokenProvider.generateToken(user.getEmail(), user.getRole().name());
        return new AuthResponse(token);
    }
}
