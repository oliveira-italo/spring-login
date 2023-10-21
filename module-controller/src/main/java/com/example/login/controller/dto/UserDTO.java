package com.example.login.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserDTO(
        @JsonProperty("uuid") String uuid,
        @JsonProperty("name") String name,
        @JsonProperty("email") String email
) {
}