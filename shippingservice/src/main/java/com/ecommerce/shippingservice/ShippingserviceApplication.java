package com.ecommerce.shippingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ecommerce.*")
public class ShippingserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShippingserviceApplication.class, args);
	}

}
