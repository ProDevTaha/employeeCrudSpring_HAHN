package com.hahn.employees.Exception;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CustomErrorResponse {
    private final LocalDateTime timestamp;
    private final String message;
    private final String details;

    public CustomErrorResponse(String message, String details) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.details = details;
    }

}
