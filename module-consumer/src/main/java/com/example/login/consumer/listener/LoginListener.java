package com.example.login.consumer.listener;

import com.example.login.consumer.message.LoginEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class LoginListener {

    @KafkaListener(topics = "login", groupId = "group-id-teste", containerFactory = "loginKafkaListenerContainerFactory")
    public void listen(LoginEvent message) {
        System.out.println("listened-1: " + message);
    }
}
