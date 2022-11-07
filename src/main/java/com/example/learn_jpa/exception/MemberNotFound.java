package com.example.learn_jpa.exception;

import com.example.learn_jpa.exception.error.ErrorCode;
import com.example.learn_jpa.exception.error.ProjectException;

public class MemberNotFound extends ProjectException {
    public static final ProjectException EXCEPTION =
            new MemberNotFound();
    private MemberNotFound() {
        super(ErrorCode.MEMBER_NOT_FOUND);
    }
}
