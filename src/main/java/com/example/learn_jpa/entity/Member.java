package com.example.learn_jpa.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
