package com.example.learn_jpa.controller.dto;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class Employee {
    private String name;
    private MultipartFile document;
}
