package com.example.login.publisher.config;

import com.example.login.commons.factory.YamlPropertySourceFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:publisher.yml", factory = YamlPropertySourceFactory.class)
public class PublisherConfig {
}
