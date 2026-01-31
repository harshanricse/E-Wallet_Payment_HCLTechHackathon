package com.hcl.E_Wallet_Payment.dto;

import com.hcl.E_Wallet_Payment.entity.User;

public class UserResponse {
    private String username;
    private String status;

    public static UserResponse from(User user) {
        UserResponse response = new UserResponse();
        response.username = user.getEmail();
        response.status = user.getStatus();
        return response;
    }

    public String getUsername() {
        return this.username;
    }

    public String getStatus() {
        return status;
    }
}

