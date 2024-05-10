package com.ngs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apiDoc() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()// It's used to specify the APIs and paths that will be included in the generated documentation.
				.apis(RequestHandlerSelectors.basePackage("com.ngs.rest"))//This means that only the APIs in this package are included in the Swagger documentation.
				.paths(PathSelectors.any())//his allows all paths to be included in the Swagger documentation. You can restrict paths if needed using regular expressions or other PathSelectors provided by Springfox.
				.build();//Finalizes the configuration and builds a new Docket instance which Spring will manage. This Docket instance contains all the configurations needed to generate the Swagger documentation.

	}

}
