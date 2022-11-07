package com.example.learn_jpa.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    MEMBER_NOT_FOUND("The Member Information can not found", 404);

    private final String message;
    private final int statusCode;
}
