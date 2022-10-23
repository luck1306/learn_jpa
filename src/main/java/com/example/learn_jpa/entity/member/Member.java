package com.example.learn_jpa.entity.member;

import com.example.learn_jpa.entity.comment.Comment;
import com.example.learn_jpa.entity.post.Post;
import com.example.learn_jpa.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Member extends BaseIdEntity {

    private String accountId;

    private String password;

    @OneToMany(mappedBy = "memberId")
    private List<Comment> comment;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Builder
    public Member(String accountId, String password, Date date) {
        this.accountId = accountId;
        this.password = password;
        this.date = date;
    }

    public void updateInfo(String accountId, String password) {
        this.accountId = accountId;
        this.password = password;
    }
}
