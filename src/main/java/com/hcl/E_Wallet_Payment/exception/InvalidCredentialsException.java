package com.hcl.E_Wallet_Payment.exception;

public class InvalidCredentialsException extends RuntimeException {

        public InvalidCredentialsException() {
            super("Invalid username or password");
        }
    }


