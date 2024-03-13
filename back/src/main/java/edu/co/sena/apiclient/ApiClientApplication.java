package edu.co.sena.apiclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class ApiClientApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApiClientApplication.class, args);
	}

}
