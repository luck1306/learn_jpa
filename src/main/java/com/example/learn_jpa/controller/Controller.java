package com.example.learn_jpa.controller;

import com.example.learn_jpa.controller.dto.request.CommentDto;
import com.example.learn_jpa.controller.dto.request.CreateMember;
import com.example.learn_jpa.controller.dto.request.FollowDto;
import com.example.learn_jpa.controller.dto.request.PostRequest;
import com.example.learn_jpa.controller.dto.response.PasswordResponse;
import com.example.learn_jpa.entity.Follow.Follow;
import com.example.learn_jpa.service.ControllerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class Controller {

    private final ControllerService controllerService;

    @PostMapping("/member")
    public void createMember(@RequestBody @Valid CreateMember createMember) {
        controllerService.createMember(createMember);
    }

    @PostMapping("/post")
    public void postMember(@RequestBody @Valid PostRequest postRequest) {
        controllerService.postCreate(postRequest);
    }

    @PostMapping("/comment")
    public void comment(@RequestBody CommentDto commentDto) { controllerService.comment(commentDto);}

    @GetMapping("/data")
    public ResponseEntity<Object> data(@RequestParam String uri) {
        return controllerService.getData(uri);
    }

    @PostMapping("/follow")
    public Follow follow(@RequestBody FollowDto followDto) {
        return controllerService.follow(followDto);
    }

    @GetMapping("/{pw}")
    public List<PasswordResponse> getIdByPw(@PathVariable String pw) {
        return controllerService.getListByPassword(pw);
    }

    @PostMapping("/sss")
    public void gg(@RequestBody String data) {
        controllerService.test(data);
    }
}
//