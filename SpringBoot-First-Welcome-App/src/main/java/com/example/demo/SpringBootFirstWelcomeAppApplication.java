package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.test.Testing;

@SpringBootApplication
public class SpringBootFirstWelcomeAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootFirstWelcomeAppApplication.class, args);
		//Testing t=ctx.getBean("test",Testing.class);
		//both work same without bean id
		Testing t=ctx.getBean(Testing.class);
		t.m1();
	}

}
