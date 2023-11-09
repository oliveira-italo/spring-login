package com.example.login.publisher.gateway;

import com.example.login.domain.entity.Login;
import com.example.login.domain.gateway.LoginGateway;
import com.example.login.publisher.mapper.LoginMapper;
import com.example.login.publisher.message.LoginEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class MessageLoginGateway implements LoginGateway {

    @Autowired
    private KafkaTemplate<String, LoginEvent> kafkaTemplate;

    @Autowired
    private LoginMapper mapper;

    @Override
    public void save(Login login) {
        CompletableFuture<SendResult<String, LoginEvent>> future = kafkaTemplate.send("login", mapper.toMessage(login));
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("published:" + result.toString());
            } else {
                System.out.println("not-published:" + ex.getMessage());
            }
        });
    }
}
