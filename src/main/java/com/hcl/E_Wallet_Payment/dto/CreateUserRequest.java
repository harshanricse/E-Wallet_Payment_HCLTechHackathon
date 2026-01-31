package com.hcl.E_Wallet_Payment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {

    private String username;

    private String password;
    private String fullName;

}
