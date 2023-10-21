package com.example.login.persistence.mapper;

import com.example.login.domain.entity.User;
import com.example.login.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    UserEntity toEntity(User user);

    User toDomain(UserEntity entity);

    UserEntity update(@MappingTarget UserEntity entity, User user);
}