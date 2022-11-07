package com.example.learn_jpa.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    POST_NOT_FOUND("The Post Information can not find", 404),
    MEMBER_NOT_FOUND("The Member Information can not find", 404);

    private final String message;
    private final int statusCode;
}
