package com.example.learn_jpa.service;

import com.example.learn_jpa.controller.dto.request.CreateMember;
import com.example.learn_jpa.entity.member.Member;
import com.example.learn_jpa.entity.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ControllerService {

    private final MemberRepository memberRepository;

    public void createMember(CreateMember createMember) {
        memberRepository.save(Member.builder()
                        .accountId(createMember.getAccountId())
                        .password(createMember.getPassword())
                        .build());
    }
}
