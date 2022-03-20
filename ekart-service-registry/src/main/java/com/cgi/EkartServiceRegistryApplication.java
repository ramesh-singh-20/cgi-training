package com.cgi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EkartServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EkartServiceRegistryApplication.class, args);
	}

}
