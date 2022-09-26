package com.sample.authsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sample.authsample")
public class AuthSampleApplication {

	public static void main(String[] args) {
		System.out.println("Trigger hook!!!");
		
		SpringApplication.run(AuthSampleApplication.class, args);
	}

}
