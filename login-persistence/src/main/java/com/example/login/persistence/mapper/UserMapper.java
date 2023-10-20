package com.example.login.persistence.mapper;

import com.example.login.entities.User;
import com.example.login.persistence.entity.UserEntity;

public class UserMapper {

    private UserMapper() {

    }

    public static UserEntity toEntity(User user) {
        return UserEntity.builder()
                .name(user.name())
                .email(user.email())
                .password(user.password())
                .build();
    }

    public static User toDomain(UserEntity entity) {
        return new User(
                entity.getName(),
                entity.getEmail(),
                entity.getPassword()
        );
    }
}
