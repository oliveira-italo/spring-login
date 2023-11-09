package com.example.login.publisher.mapper;

import com.example.login.domain.entity.Login;
import com.example.login.publisher.message.LoginEvent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoginMapper {
    LoginEvent toMessage(Login login);
}
