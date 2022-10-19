package com.example.learn_jpa.entity.member;

import com.example.learn_jpa.global.entity.BaseIdEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@Getter
@Entity
public class Member extends BaseIdEntity {

    private String accountId;

    private String password;

    @Builder
    public Member(String accountId, String password) {
        this.accountId = accountId;
        this.password = password;
    }

    public void updateInfo(String accountId, String password) {
        this.accountId = accountId;
        this.password = password;
    }
}
