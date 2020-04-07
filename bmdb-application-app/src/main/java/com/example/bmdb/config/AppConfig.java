package com.example.bmdb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({MessageConfig.class, DomainMockConfig.class, WebSecurityConfig.class})
public class AppConfig {
}


