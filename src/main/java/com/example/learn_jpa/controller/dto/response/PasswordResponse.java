package com.example.learn_jpa.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PasswordResponse {

    private final Long id;
    private final String accountId;

    @Builder
    public PasswordResponse(Long id, String accountId) {
        this.id = id;
        this.accountId = accountId;
    }
}
