package com.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class BootEurekaDiscoveyClientApplication {
	
	@GetMapping("/wish")
	public String showMsg() {
		return "Good Night Wasim";
	}
	public static void main(String[] args) {
		SpringApplication.run(BootEurekaDiscoveyClientApplication.class, args);
	}

}
