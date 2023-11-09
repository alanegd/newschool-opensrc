package io.newschool.platform.u.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI learningPlatformOpenApi() {
        return new OpenAPI()
                .info(new Info()
                .title("Sports.com API")
                .description("Sports.com application REST API documentation.")
                .version("v1.0.0")
                .contact(new io.swagger.v3.oas.models.info.Contact()
                        .name("EGD")));
    }
}
