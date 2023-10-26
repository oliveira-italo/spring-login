package com.example.login.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record LoginForm(

        @JsonProperty("email")
        @Email
        @NotEmpty
        String email,

        @JsonProperty("password")
        @NotEmpty
        String password
) {
}
