package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WishController {
	
	@GetMapping("/welcome")
	public String showWelcome() {
		return "welcome";
	}
}
