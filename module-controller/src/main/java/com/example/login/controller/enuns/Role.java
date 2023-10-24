package com.example.login.controller.enuns;

public enum Role {
    ROLE_USER,
    ROLE_ADMIN,

    ;

    public String removePrefix() {
        return this.name().replace("ROLE_", "");
    }
}
