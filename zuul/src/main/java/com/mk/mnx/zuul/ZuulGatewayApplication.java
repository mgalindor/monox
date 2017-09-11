package com.mk.mnx.zuul;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ZuulGatewayApplication {	
	public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulGatewayApplication.class).web(true).run(args);
    }

}
