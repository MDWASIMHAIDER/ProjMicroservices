package com.hystrix;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HystrixTest {
	private static final String REST_URL="https://spring-boot-app-currencyapp.cfapps.io/currency/getRate/from/USD/to/INR";
	
	@GetMapping("/getCost")
	@HystrixCommand(fallbackMethod="alternateMethod")
	public String getCurrencyCost() {
		 WebClient webClient = WebClient.builder().build();
		 String response = webClient.get()
		 		  .uri(REST_URL)
		 		  .retrieve()
		 		  .bodyToMono(String.class)
		 		  .block();
		return response;
	}
	
	public String alternateMethod() {
		return "FallBack Called";
	}
}
