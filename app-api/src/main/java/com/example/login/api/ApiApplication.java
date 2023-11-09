package com.example.login.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "com.example.login.controller",
                "com.example.login.domain",
                "com.example.login.persistence",
                "com.example.login.publisher",
                "com.example.login.commons"
        }
)
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}