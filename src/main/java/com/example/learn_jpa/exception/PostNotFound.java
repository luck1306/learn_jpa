package com.example.learn_jpa.exception;

import com.example.learn_jpa.exception.error.ErrorCode;
import com.example.learn_jpa.exception.error.ProjectException;

public class PostNotFound extends ProjectException {
    public static final ProjectException EXCEPTION =
            new PostNotFound();
    private PostNotFound() {
        super(ErrorCode.POST_NOT_FOUND);
    }
}
