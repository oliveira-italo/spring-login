package com.example.login.domain.entity;

import java.time.LocalDateTime;

public record Login(
        String username,
        LocalDateTime dateTime,
        boolean successful
) {
}