package com.app.MyFPortfolio;

// import java.util.function.Predicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MyFPortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFPortfolioApplication.class, args);
		
	}

}
