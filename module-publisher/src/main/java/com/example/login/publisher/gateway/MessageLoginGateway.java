package com.example.login.publisher.gateway;

import com.example.login.domain.entity.Login;
import com.example.login.domain.gateway.LoginGateway;
import org.springframework.stereotype.Component;

@Component
public class MessageLoginGateway implements LoginGateway {
    @Override
    public void save(Login login) {
        System.out.println("published:" + login);
    }
}
