package io.github.anantharajuc.hibernate.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Hibernate")
                        .description("Hibernate Examples with OPen API 3.0")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Anantha")
                                .url("anantharajuc.github.io")
                                .email("example@domain.com"))
                        .termsOfService("https://github.com/AnanthaRajuC/hibernate/blob/main/LICENSE.md")
                        .license(new License().name("MIT License").url("https://github.com/AnanthaRajuC/hibernate/blob/main/LICENSE.md"))
                );
    }
}
