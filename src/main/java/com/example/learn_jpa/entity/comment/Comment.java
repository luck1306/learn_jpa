package com.example.learn_jpa.entity.comment;

import com.example.learn_jpa.entity.member.Member;
import com.example.learn_jpa.entity.post.Post;
import com.example.learn_jpa.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(CommentId.class)
@Entity
public class Comment extends BaseIdEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member memberId;

    @Id
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post postId;

    private String comment;

    @Builder
    public Comment(Member member, Post post, String comment) {
        this.memberId = member;
        this.postId = post;
        this.comment = comment;
    }
}
