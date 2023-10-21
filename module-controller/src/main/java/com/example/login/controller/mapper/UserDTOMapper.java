package com.example.login.controller.mapper;

import com.example.login.controller.dto.UserDTO;
import com.example.login.controller.form.UserForm;
import com.example.login.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserDTOMapper {

    UserDTO toDto(User user);

    User toDomain(UserForm form);

    @Mapping(target = "uuid", source = "uuid")
    User toDomain(UserForm form, String uuid);
}
