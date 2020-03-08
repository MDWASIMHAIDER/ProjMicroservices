package com.nt.wasim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

	public WelcomeController() {
		System.out.println("WelcomeController.WelcomeController()");
	}
	
	@RequestMapping("/welcome")
	public String showWelcome(Model model) {
		String msg="Welcome to Spring Boot!!";
		model.addAttribute("msg",msg);
		return "welcome";
	}
	
	@RequestMapping("/wish")
	public String wishMessage(@RequestParam("name")String name,Model model){
		String msg=name+" Welcom to Spring Boot";
		model.addAttribute("msg",msg);
		return "wishUser";
	}

}
