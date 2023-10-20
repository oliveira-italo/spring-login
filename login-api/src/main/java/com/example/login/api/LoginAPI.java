package com.example.login.api;

import com.example.login.persistence.config.PersistenceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(
		scanBasePackages = {
				"com.example.login.controller",
				"com.example.login.usecase",
				"com.example.login.persistence"
		}
)
public class LoginAPI {

	public static void main(String[] args) {
		SpringApplication.run(LoginAPI.class, args);
	}
}