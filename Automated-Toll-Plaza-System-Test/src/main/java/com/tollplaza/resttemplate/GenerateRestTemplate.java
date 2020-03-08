package com.tollplaza.resttemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GenerateRestTemplate {
	
	@Bean
	public RestTemplate generateTemplate() {
		RestTemplate rt=new RestTemplate();
		return rt;
	}
}
