package com.chat.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
    ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("User Service for Tek Social")
                .description(
                        "Sample APIs for USER SERVICE")
                .termsOfServiceUrl("").version("0.0.1-SNAPSHOT").contact(new Contact("Madhav Bhat K", "kmadhav907@gmail.com", "kmadhav907@gmail.com")).build();
    }

    @Bean
    public Docket configureControllerPackageAndConvertors() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.chat.userservice.controllers")).build()
                .apiInfo(apiInfo());
    }
}
