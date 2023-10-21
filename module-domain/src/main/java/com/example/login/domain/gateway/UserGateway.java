package com.example.login.domain.gateway;

import com.example.login.domain.entity.User;

import java.util.Optional;

public interface UserGateway {
    User create(User user);

    Optional<User> update(User user);

    Optional<User> read(String uuid);

    Long delete(String uuid);
}
