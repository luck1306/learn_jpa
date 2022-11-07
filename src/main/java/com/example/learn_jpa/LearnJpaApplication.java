package com.example.learn_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LearnJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnJpaApplication.class, args);
    }

}
