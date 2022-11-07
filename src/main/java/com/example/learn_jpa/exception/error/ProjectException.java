package com.example.learn_jpa.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProjectException extends RuntimeException{
    private final ErrorCode errorCode;
}
