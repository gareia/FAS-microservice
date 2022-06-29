package com.example.usermicroservice.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean(name = "userMicroserviceOpenApi")
    public OpenAPI userMicroserviceOpenApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("User Microservice API")
                        .description(
                                "Aplicación de moda masculina - User"));
    }
}
