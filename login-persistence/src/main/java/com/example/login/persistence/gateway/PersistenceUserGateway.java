package com.example.login.persistence.gateway;

import com.example.login.entities.User;
import com.example.login.persistence.entity.UserEntity;
import com.example.login.persistence.mapper.UserMapper;
import com.example.login.persistence.repository.UserRepository;
import com.example.login.usecase.gateway.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersistenceUserGateway implements UserGateway {

    @Autowired
    private UserRepository repository;

    @Override
    public User create(User user) {
        UserEntity entity = repository.save(UserMapper.toEntity(user));
        return UserMapper.toDomain(entity);
    }
}
