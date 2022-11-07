package com.example.learn_jpa.controller.dto.request;

import lombok.Getter;

@Getter
public class CommentDto {

    private Long memberId;

    private Long postId;

    private String comment;

}
