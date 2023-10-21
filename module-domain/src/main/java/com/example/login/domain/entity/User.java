package com.example.login.domain.entity;

public record User(
        String uuid,
        String name,
        String email,
        String password
) {
}