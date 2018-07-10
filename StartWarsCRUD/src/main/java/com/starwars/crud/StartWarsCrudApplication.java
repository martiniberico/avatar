package com.starwars.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.starwars.api.RestApiController;

@SpringBootApplication
@ComponentScan(basePackageClasses = RestApiController.class)
public class StartWarsCrudApplication { 
	
	public static void main(String[] args) {
		SpringApplication.run(StartWarsCrudApplication.class, args);
	}
}
