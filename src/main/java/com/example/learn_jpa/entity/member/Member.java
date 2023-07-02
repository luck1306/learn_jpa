package com.example.learn_jpa.entity.member;

import com.example.learn_jpa.entity.comment.Comment;
import com.example.learn_jpa.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountId;

    private String password;

    private Integer number;

    @OneToMany(mappedBy = "memberId")
    private List<Comment> comment;

    @Builder
    public Member(String accountId, String password, Integer number) {
        this.accountId = accountId;
        this.password = password;
        this.number = number;
    }

    public void updateInfo(String accountId, String password) {
        this.accountId = accountId;
        this.password = password;
    }
}
