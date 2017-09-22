package com.mk.mnx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableEurekaClient
@ImportResource("classpath:application-context.xml")
public class StartUpService {

	public static void main(String[] args) {
		SpringApplication.run(StartUpService.class, args);
	}

}
