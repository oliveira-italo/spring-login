package com.example.login.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class User {
    private final String uuid;
    private final String name;
    private final String email;
    @Setter
    private String password;
    @Setter
    private Role role;
}