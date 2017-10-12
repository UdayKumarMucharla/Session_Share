package com.kgfsl.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = "com.kgfsl")
public class SessionShareApplication {

	public static void main(String[] args) {
		SpringApplication.run(SessionShareApplication.class, args);
	}
}
