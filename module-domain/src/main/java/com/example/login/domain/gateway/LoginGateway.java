package com.example.login.domain.gateway;

import com.example.login.domain.entity.Login;

public interface LoginGateway {
    void save(Login login);
}
