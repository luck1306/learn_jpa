package com.example.learn_jpa.entity.post;

import com.example.learn_jpa.entity.member.Member;
import com.example.learn_jpa.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post extends BaseIdEntity {

    private String content;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
}
