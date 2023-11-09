package com.example.login.consumer.config;

import com.example.login.commons.factory.YamlPropertySourceFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:consumer.yml", factory = YamlPropertySourceFactory.class)
public class ConsumerConfig {
}
