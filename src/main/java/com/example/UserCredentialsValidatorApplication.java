package com.example;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;
import java.util.Collections;


@SpringBootApplication
@EnableTransactionManagement
@EnableSwagger2
public class UserCredentialsValidatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCredentialsValidatorApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/signup/*"))
				.apis(RequestHandlerSelectors.basePackage("com.example"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails(){
		return new ApiInfo(
				"Signup Api",
				"Learning Spring BOot",
				"Version 1.0",
				"Terms of Service URL (NO IDEAD)",
				new springfox.documentation.service.Contact("zahid","will.make.soon","zahidsaleem0440@gmail.com"),
				"License",
				"will.make.soon",
				Collections.emptyList());

	}

}
