package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SportyShoeFirstApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(SportyShoeFirstApplication.class, args);
//		Springapplicationco
//		ProductRepositoryImpl productRepositoryImpl = context.getBean(ProductRepositoryImpl.class);
//		productRepositoryImpl.deleteProduct();
	}

}
