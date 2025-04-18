package com.example.springbootjenkinskubernetes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootJenkinsKubernetesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJenkinsKubernetesApplication.class, args);
    }

    @GetMapping("")
    public String hello() {
        return "Hello World2";
    }
}
