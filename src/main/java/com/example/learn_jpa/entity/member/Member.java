package com.example.learn_jpa.entity.member;

import com.example.learn_jpa.entity.comment.Comment;
import com.example.learn_jpa.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Member extends BaseTimeEntity {

    private String accountId;

    private String password;

    @OneToMany(mappedBy = "memberId")
    private List<Comment> comment;

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
