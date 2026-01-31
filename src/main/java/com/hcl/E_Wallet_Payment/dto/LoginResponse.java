package com.hcl.E_Wallet_Payment.dto;

public class LoginResponse {
    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }
}