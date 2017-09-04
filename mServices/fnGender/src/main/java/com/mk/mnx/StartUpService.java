package com.mk.mnx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:application-context.xml")
public class StartUpService {

	public static void main(String[] args) {
		SpringApplication.run(StartUpService.class, args);
	}
}
