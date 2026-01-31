package com.hcl.E_Wallet_Payment.exception;

import java.time.Instant;

public class ApiError {

    private int status;
    private String message;
    private Instant timestamp;

    public ApiError(int status, String message, Instant timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
