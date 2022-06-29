package com.example.postmicroservice.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JPAConfig {
    @Bean
    public DataSource getDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/post_microservice?useSSL=false&serverTimezone=UTC&userLegacyDatetimeCode=false");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("appserv9");
        return dataSourceBuilder.build();
    }
}
