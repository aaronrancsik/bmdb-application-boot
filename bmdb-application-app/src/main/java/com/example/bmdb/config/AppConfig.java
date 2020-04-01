package com.example.bmdb.config;

import com.example.bmdb.app.AppSpring;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;



@Configuration
@ComponentScan("com.example")
//
//
@Import({ MessageConfig.class, PersistenceJPAConfig.class, DomainMockConfig.class })
public class AppConfig {


    @Bean
    public AppSpring createAppSpring(){
        return new AppSpring();
    }



}
