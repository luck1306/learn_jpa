package com.example.learn_jpa.exception.error;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ErrorResponse {
    private int statusCode;
    private String message;

    @Builder
    public ErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
