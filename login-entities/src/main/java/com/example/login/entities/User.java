package com.example.login.entities;

public record User(
        String name,
        String email,
        String password
) {
}