package com.example.login.domain.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String uuid) {
        super("User [uuid=%s] not found.".formatted(uuid));
    }
}
