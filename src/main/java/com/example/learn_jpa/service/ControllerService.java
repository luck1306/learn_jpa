package com.example.learn_jpa.service;

import com.example.learn_jpa.controller.dto.request.CommentDto;
import com.example.learn_jpa.controller.dto.request.CreateMember;
import com.example.learn_jpa.controller.dto.request.FollowDto;
import com.example.learn_jpa.controller.dto.request.PostRequest;
import com.example.learn_jpa.entity.Follow.Follow;
import com.example.learn_jpa.entity.Follow.repository.FollowRepository;
import com.example.learn_jpa.entity.comment.Comment;
import com.example.learn_jpa.entity.comment.repository.CommentRepository;
import com.example.learn_jpa.entity.member.Member;
import com.example.learn_jpa.entity.member.repository.MemberRepository;
import com.example.learn_jpa.entity.post.Post;
import com.example.learn_jpa.entity.post.repository.PostRepository;
import com.example.learn_jpa.exception.MemberNotFound;
import com.example.learn_jpa.exception.PostNotFound;
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


@Slf4j
@RequiredArgsConstructor
@Service
public class ControllerService {

    private final MemberRepository memberRepository;

    private final PostRepository postRepository;

    private final FollowRepository followRepository;

    private final CommentRepository commentRepository;

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

    public void comment(CommentDto commentDto) {
        commentRepository.save(Comment.builder()
                        .comment(commentDto.getComment())
                        .member(memberRepository.findById(commentDto.getMemberId())
                                .orElseThrow(() -> {throw MemberNotFound.EXCEPTION;}))
                        .post(postRepository.findById(commentDto.getPostId())
                                .orElseThrow(() -> {throw PostNotFound.EXCEPTION;}))
                .build());
    }

    // external api
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

    public Follow follow(FollowDto followDto) {

        Member followerResult = memberRepository.findByAccountId(followDto.getFollower())
                .orElseThrow(() -> {throw MemberNotFound.EXCEPTION;});
        Member followingResult = memberRepository.findByAccountId(followDto.getFollowing())
                .orElseThrow(() -> {throw MemberNotFound.EXCEPTION;});

        return followRepository.save(Follow.builder()
                .follower(followerResult)
                .following(followingResult)
                .build());
    }
}
