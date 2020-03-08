package com.h2db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InMemoryDbH2Application {

	public static void main(String[] args) {
		SpringApplication.run(InMemoryDbH2Application.class, args);
	}

}
