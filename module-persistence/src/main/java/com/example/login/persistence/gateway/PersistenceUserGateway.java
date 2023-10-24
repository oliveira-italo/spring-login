package com.example.login.persistence.gateway;

import com.example.login.domain.entity.User;
import com.example.login.domain.gateway.UserGateway;
import com.example.login.persistence.mapper.UserEntityMapper;
import com.example.login.persistence.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PersistenceUserGateway implements UserGateway {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserEntityMapper mapper;

    @Override
    @Transactional
    public User create(User user) {
        return mapper.toDomain(repository.save(mapper.toEntity(user)));
    }

    @Override
    public Optional<User> read(String uuid) {
        return repository.findByUuid(uuid).map(entity -> mapper.toDomain(entity));
    }

    @Override
    @Transactional
    public Long delete(String uuid) {
        return repository.deleteByUuid(uuid);
    }

    @Override
    public Optional<User> readByEmail(String email) {
        return repository.findByEmail(email).map(entity -> mapper.toDomain(entity));
    }

    @Override
    @Transactional
    public Optional<User> update(User user) {
        return repository.findByUuid(user.getUuid())
                .map(entity -> mapper.update(entity, user))
                .map(updatedEntity -> mapper.toDomain(updatedEntity));
    }


}
