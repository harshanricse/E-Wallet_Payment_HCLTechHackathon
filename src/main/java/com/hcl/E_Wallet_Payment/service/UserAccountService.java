package com.hcl.E_Wallet_Payment.service;

import com.hcl.E_Wallet_Payment.entity.User;
import com.hcl.E_Wallet_Payment.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {
    @Autowired
    private final UserAccountRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserAccountService(UserAccountRepository repository,
                              PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(String email, String rawPassword, String fullName) {
        User user = new User();
        user.setEmail(email);
        user.setEncryptedPassword(passwordEncoder.encode(rawPassword));
        user.setFullName(fullName);
        user.setStatus("ACTIVE");
        return repository.save(user);
    }
}
