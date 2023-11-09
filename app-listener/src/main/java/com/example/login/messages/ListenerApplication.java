package com.example.login.messages;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "com.example.login.consumer",
                "com.example.login.domain",
                "com.example.login.persistence",
                "com.example.login.publisher",
                "com.example.login.commons"
        }
)
public class ListenerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ListenerApplication.class, args);
    }
}
