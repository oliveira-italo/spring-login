package com.example.login.usecase.interactor;

import com.example.login.entities.User;
import com.example.login.usecase.gateway.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInteractor {

    @Autowired
    private UserGateway gateway;

    public User create(User user) {
        return gateway.create(user);
    }

}
