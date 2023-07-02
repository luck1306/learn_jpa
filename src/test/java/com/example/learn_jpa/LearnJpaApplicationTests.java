package com.example.learn_jpa;

import com.example.learn_jpa.controller.Controller;
import com.example.learn_jpa.service.ControllerService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LearnJpaApplicationTests {

    private final ControllerService controllerService;
    @Test
    void contextLoads() {
    }

    public LearnJpaApplicationTests(ControllerService controllerService) {
        this.controllerService = controllerService;
    }

    public ControllerService getControllerService() {
        return controllerService;
    }
}
