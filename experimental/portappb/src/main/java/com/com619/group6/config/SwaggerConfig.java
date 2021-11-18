package com.com619.group6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).forCodeGeneration(Boolean.TRUE).select()
				.apis(RequestHandlerSelectors.basePackage("com.com619.group6.controllers")).paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
	}

	@Bean
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Port App API").description("API for Port Application").version("1.0.0")
				.build();
	}

	@Bean
	public UiConfiguration uiConfiguration() {
		return UiConfigurationBuilder.builder().deepLinking(true).validatorUrl(null).build();
	}
}