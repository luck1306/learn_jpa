package com.example.learn_jpa.exception.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ProjectException.class})
    protected ResponseEntity<ErrorResponse> projectExceptionHandler(ProjectException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getErrorCode().getStatusCode(), e.getErrorCode().getMessage()),
                HttpStatus.valueOf(e.getErrorCode().getStatusCode()));
    }
}
