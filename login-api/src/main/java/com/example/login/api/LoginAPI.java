package com.example.login.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {
				"com.example.login.usecase",
				"com.example.login.persistence"
		}
)
public class LoginAPI {

	public static void main(String[] args) {
		SpringApplication.run(LoginAPI.class, args);
	}
}