package com.hcl.E_Wallet_Payment.service;

import com.hcl.E_Wallet_Payment.entity.User;
import com.hcl.E_Wallet_Payment.exception.InvalidCredentialsException;
import com.hcl.E_Wallet_Payment.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private final UserAccountRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthenticationService(UserAccountRepository repository,
                                 PasswordEncoder passwordEncoder,
                                 JwtService jwtService) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String login(String username, String rawPassword) {

        User user = repository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(rawPassword, user.getEncryptedPassword())) {
            throw new InvalidCredentialsException();
        }

        return jwtService.generateToken(user);
    }
}

