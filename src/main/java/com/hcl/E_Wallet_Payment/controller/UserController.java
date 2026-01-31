package com.hcl.E_Wallet_Payment.controller;

import com.hcl.E_Wallet_Payment.dto.CreateUserRequest;
import com.hcl.E_Wallet_Payment.dto.UserResponse;
import com.hcl.E_Wallet_Payment.entity.User;
import com.hcl.E_Wallet_Payment.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private final UserAccountService userAccountService;

    public UserController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    /**
     * Create a new user account (Registration)
     */

    @PostMapping
    public ResponseEntity<UserResponse> createUser(
            @RequestBody CreateUserRequest request) {

        User user = userAccountService.createUser(
                request.getUsername(),
                request.getPassword(),
                request.getFullName()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(UserResponse.from(user));
    }

    /**
     * Get user details by ID
     */
//    @GetMapping("/{userId}")
//    public ResponseEntity<UserResponse> getUserById(
//            @PathVariable UUID userId) {
//
//        User user = userAccountService.getUserById(userId);
//        return ResponseEntity.ok(UserResponse.from(user));
//    }
}

