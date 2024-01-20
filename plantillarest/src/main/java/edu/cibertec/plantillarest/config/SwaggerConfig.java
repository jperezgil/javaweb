package edu.cibertec.plantillarest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI usersMicroserviceOpenAPI() { 
        return new OpenAPI()
                .info(new Info().title("API REST")
                                 .description("DESCRIPCION DE MI API REST")
                                 .version("1.0")
                                 .contact(new Contact().email("jperezgil@outlook.com")
                                                       .name("JPEREZGIL"))
                                 .license(new License().name("Apache 2.0")
                                                       .url("http://springdoc.org")));                   
    }
}
