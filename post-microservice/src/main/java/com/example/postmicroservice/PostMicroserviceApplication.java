package com.example.postmicroservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaAuditing
public class PostMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostMicroserviceApplication.class, args);
    }

    @Bean
    public RestTemplate getresttemplate() {
        return new RestTemplate();
    }

    @Bean
    public ModelMapper modelMapper(){

        return new ModelMapper();
    }
}
