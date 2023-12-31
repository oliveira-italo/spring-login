package com.example.login.controller.form;

import com.example.login.controller.enuns.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserForm(
        @NotEmpty
        @JsonProperty("name")
        String name,

        @Email
        @NotEmpty
        @JsonProperty("email")
        String email,

        @Size(min = 8, max = 8)
        @JsonProperty("password")
        String password,

        @JsonProperty("role")
        @NotNull
        Role role
) {
}