package com.example.login.domain.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String key) {
        super("User [%s] not found.".formatted(key));
    }
}
