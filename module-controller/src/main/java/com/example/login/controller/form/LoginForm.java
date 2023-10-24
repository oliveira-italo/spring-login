package com.example.login.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record LoginForm(

        @JsonProperty("login")
        @Email
        @NotEmpty
        String login,

        @JsonProperty("password")
        @NotEmpty
        String password
) {
}
