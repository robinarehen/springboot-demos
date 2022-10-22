package com.example.demo.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder().group("products").pathsToMatch("/**").build();
	}

	@Bean
	public OpenAPI springShopOpenAPI() {
		License license = new License();
		license.name("Apache 2.0");
		license.url("http://springdoc.org");

		Info info = new Info();
		info.title("Products API");
		info.description("Spring product sample application");
		info.version("v0.0.1");
		info.license(license);

		return new OpenAPI().info(info);
	}
}
