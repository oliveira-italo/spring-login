package com.example.login.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TokenDTO(
        @JsonProperty("token") String token
) {
}
