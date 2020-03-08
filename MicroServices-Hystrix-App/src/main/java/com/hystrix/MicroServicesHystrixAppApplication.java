package com.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrix
//@EnableHystrixDashboard
@EnableCircuitBreaker
public class MicroServicesHystrixAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicesHystrixAppApplication.class, args);
	}

}
