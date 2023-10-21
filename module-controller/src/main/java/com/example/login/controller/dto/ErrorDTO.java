package com.example.login.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ErrorDTO(
        @JsonProperty("message") String message
) {
}