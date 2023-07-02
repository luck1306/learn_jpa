package com.example.learn_jpa.entity.post;

import com.example.learn_jpa.entity.comment.Comment;
import com.example.learn_jpa.entity.member.Member;
import com.example.learn_jpa.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post extends BaseIdEntity {

    private String content;

    @OneToMany(mappedBy = "postId")
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Post(String content, Member member) {
        this.content = content;
        this.member = member;
    }
}
