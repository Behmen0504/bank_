package com.sinam.mybank.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

//    static {
//        SpringDocUtils.getConfig().addRequestWrapperToIgnore(java.util.Optional.class);
//    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Tutorial Management API").version("1.0")
                        .description("This API exposes endpoints to manage tutorials.")
                        .termsOfService("https://www.bezkoder.com/terms"))
                .addSecurityItem(new SecurityRequirement().addList("bearerKey"))
                .components(
                        new Components()
                                .addSecuritySchemes("bearerKey",
                                        new SecurityScheme()
                                                .name("bearerKey")
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                                .in(SecurityScheme.In.HEADER)
                                                .description("For inserting JWT type Bearer in a dialog box.")
                                )
                );
    }

}
