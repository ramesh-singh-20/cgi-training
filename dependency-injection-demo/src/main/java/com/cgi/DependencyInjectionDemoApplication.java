package com.cgi;

import com.cgi.dao.EmailDAO;
import com.cgi.service.EmailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependencyInjectionDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DependencyInjectionDemoApplication.class, args);
		EmailService service= new EmailService(new EmailDAO());
		service.sendEmail();

	}

}
