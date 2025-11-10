package com.jogoteca.config;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class OpenApiConfig {
    @Bean public OpenAPI openAPI(){return new OpenAPI().info(new Info().title("Jogoteca API").description("CRUD de Jogos — tema estiloso para o trabalho prático").version("v1.0").license(new License().name("MIT"))).externalDocs(new ExternalDocumentation().description("Swagger UI").url("/swagger-ui.html"));}
}