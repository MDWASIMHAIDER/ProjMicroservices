package com.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class OAuthProtocalAppApplication {

	@GetMapping("/")
	public String showMessage() {
		return "Welcome OAuth2.0 Security..!!!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(OAuthProtocalAppApplication.class, args);
	}

}
