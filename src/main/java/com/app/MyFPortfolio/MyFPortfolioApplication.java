package com.app.MyFPortfolio;

// import java.util.function.Predicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class MyFPortfolioApplication {
	// @Bean
	// public Docket api() {
	// 	return new Docket(DocumentationType.SWAGGER_2)
	// 		.select()
	// 		.apis(RequestHandlerSelectors.any())
	// 		.paths(PathSelectors.any())
	// 		.paths(Predicate.not(PathSelectors.regex("/error.*")))
	// 		.build();
	// }

	public static void main(String[] args) {
		SpringApplication.run(MyFPortfolioApplication.class, args);
		
	}

}
