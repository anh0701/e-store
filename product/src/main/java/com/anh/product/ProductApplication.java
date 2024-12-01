package com.anh.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		System.out.println("Swagger: http://localhost:8080/swagger-ui/index.html");
		SpringApplication.run(ProductApplication.class, args);
	}

}
