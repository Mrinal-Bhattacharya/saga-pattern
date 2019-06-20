package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({ "com.ecommerce.controller", "com.ecommerce.service", "com.ecommerce.aggregates",
		"com.ecommerce.config", "com.ecommerce.dto", "com.ecommerce.saga" })
@SpringBootApplication
public class OrderserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderserviceApplication.class, args);
		
	}

}
