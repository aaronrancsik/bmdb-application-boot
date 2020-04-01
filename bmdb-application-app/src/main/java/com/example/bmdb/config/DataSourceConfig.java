package com.example.bmdb.config;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {
    private static final String URL = "jdbc:mysql://localhost/bmdb_rancsik_aron";
    private static final String USER = "aaron";
    private static final String PASSWORD = "Maria_a_kulcsot!";

    @Bean
    public DataSource dateSource(){
        return new DriverManagerDataSource(URL, USER, PASSWORD);
    }
}
