package com.example.learn_jpa.entity.comment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CommentId implements Serializable {

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "post_id")
    private Long postId;
}
