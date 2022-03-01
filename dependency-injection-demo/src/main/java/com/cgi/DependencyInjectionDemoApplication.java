package com.cgi;

import com.cgi.service.EmailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependencyInjectionDemoApplication {

	public static void main(String[] args) {
		EmailService service= new EmailService();
		service.sendEmail();
		SpringApplication.run(DependencyInjectionDemoApplication.class, args);

	}

}
