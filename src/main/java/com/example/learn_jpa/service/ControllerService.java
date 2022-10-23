package com.example.learn_jpa.service;

import com.example.learn_jpa.controller.dto.request.CreateMember;
import com.example.learn_jpa.controller.dto.request.PostRequest;
import com.example.learn_jpa.entity.member.Member;
import com.example.learn_jpa.entity.member.repository.MemberRepository;
import com.example.learn_jpa.entity.post.Post;
import com.example.learn_jpa.entity.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ControllerService {

    private final MemberRepository memberRepository;

    private final PostRepository postRepository;

    public void createMember(CreateMember createMember) {
        memberRepository.save(Member.builder()
                        .accountId(createMember.getAccountId())
                        .password(createMember.getPassword())
                        .build());
    }

    public void postCreate(PostRequest postRequest) {
        Member member = memberRepository.findByAccountId(postRequest.getMember()).orElseThrow(RuntimeException::new);
        postRepository.save(Post.builder()
                        .content(postRequest.getContent())
                        .member(member)
                .build());
    }
}
