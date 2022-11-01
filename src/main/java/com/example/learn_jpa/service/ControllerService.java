package com.example.learn_jpa.service;

import com.example.learn_jpa.controller.dto.request.CreateMember;
import com.example.learn_jpa.controller.dto.request.PostRequest;
import com.example.learn_jpa.entity.member.Member;
import com.example.learn_jpa.entity.member.repository.MemberRepository;
import com.example.learn_jpa.entity.post.Post;
import com.example.learn_jpa.entity.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;

@Slf4j
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

    public ResponseEntity<Object> getData(String url) {
        ResponseEntity<Object> responseMap = new ResponseEntity<>(null, null, 200);
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(headers);

            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();
            responseMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Object.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.info("error");
            log.info(e.toString());

            return responseMap;
        }
        catch (Exception e) {
            log.info(e.toString());

            return responseMap;
        }
        return responseMap;
    }
}
