package com.example.login.usecase.gateway;

import com.example.login.entities.User;

public interface UserGateway {
    User create(User user);
}
