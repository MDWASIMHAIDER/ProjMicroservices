package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringRestApiTestApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringRestApiTestApplication.class, args);
		System.out.println("hello");
	}

}
