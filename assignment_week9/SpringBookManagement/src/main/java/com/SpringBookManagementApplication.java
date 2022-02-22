package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication(scanBasePackages = "com")
@EntityScan(basePackages ="com.bean")
@EnableJpaRepositories(basePackages = "com.dao")
@EnableSwagger2
public class SpringBookManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBookManagementApplication.class, args);
		System.err.print("Server running on 9090");		
	}
	@Bean						
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com"))
				.build();

	}

}
