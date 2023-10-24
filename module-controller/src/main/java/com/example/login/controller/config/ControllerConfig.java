package com.example.login.controller.config;

import com.example.login.controller.factory.YamlPropertySourceFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:controller.yml", factory = YamlPropertySourceFactory.class)
public class ControllerConfig {
}
