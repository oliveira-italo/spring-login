package com.example.login.controller.mapper;

import com.example.login.controller.dto.UserDTO;
import com.example.login.controller.dto.UserLoginDTO;
import com.example.login.controller.form.UserForm;
import com.example.login.domain.entity.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring")
public abstract class UserDTOMapper {

    @Autowired
    protected PasswordEncoder passwordEncoder;

    public abstract UserDTO toDto(User user);

    public abstract User toDomain(UserForm form);

    @Mapping(target = "uuid", source = "uuid")
    public abstract User toDomain(UserForm form, String uuid);

    public abstract UserLoginDTO toLoginDTO(User user);

    @AfterMapping
    protected void afterMappingUser(@MappingTarget User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }
}
