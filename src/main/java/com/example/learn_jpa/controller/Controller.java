package com.example.learn_jpa.controller;

import com.example.learn_jpa.controller.dto.request.CreateMember;
import com.example.learn_jpa.controller.dto.request.PostRequest;
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

@RequiredArgsConstructor
@RestController
public class Controller {

    private final ControllerService controllerService;

    @PostMapping("/create-member")
    public void createMember(@RequestBody @Valid CreateMember createMember) {
        controllerService.createMember(createMember);
    }

    @PostMapping("/create-post")
    public void postMember(@RequestBody @Valid PostRequest postRequest) {
        controllerService.postCreate(postRequest);
    }

    @GetMapping("/data")
    public ResponseEntity<Object> data(@RequestParam String uri) {
        return controllerService.getData(uri);
    }
}
