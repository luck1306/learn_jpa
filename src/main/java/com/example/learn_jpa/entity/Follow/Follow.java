package com.example.learn_jpa.entity.Follow;

import com.example.learn_jpa.entity.member.Member;
import com.example.learn_jpa.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Follow extends BaseIdEntity {

    @ManyToOne
    @JoinColumn(name = "following")
    private Member following;

    @ManyToOne
    @JoinColumn(name = "follower")
    private Member follower;

    @Builder
    public Follow(Member following, Member follower) {
        this.follower = follower;
        this.following = following;
    }
}
