package com.example.login.persistence.config;

import com.example.login.commons.factory.YamlPropertySourceFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.login.persistence.repository")
@EntityScan(basePackages = "com.example.login.persistence.entity")
@PropertySource(value = "classpath:persistence.yml", factory = YamlPropertySourceFactory.class)
public class PersistenceConfig {
}