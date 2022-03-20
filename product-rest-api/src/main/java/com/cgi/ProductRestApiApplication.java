package com.cgi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductRestApiApplication.class, args);
	}

}
