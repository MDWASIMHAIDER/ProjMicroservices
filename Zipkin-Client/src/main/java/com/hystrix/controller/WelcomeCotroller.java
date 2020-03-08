package com.hystrix.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeCotroller {
	
	
	@GetMapping("/msg")
	public String getMsg() {
		String msg="hello World";
		return msg;
	}
}
