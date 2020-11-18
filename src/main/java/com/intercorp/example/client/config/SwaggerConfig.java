package com.intercorp.example.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket administrationTicketsApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.intercorp.example.client.controller"))
				.paths(regex("/v1.*")).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		String description = "Cliente REST API";
		return new ApiInfoBuilder().title("Cliente REST API").description(description).licenseUrl("")
				.version("1.0").build();
	}
}