package com.example.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.BookService;

@Controller
public class UserExceptionController {
	
	@Autowired
	BookService service;
	
	@GetMapping("/home")
	public String showHome(Model model) {
		model.addAttribute("date", "Today Date is "+new Date());
		String s=null;
		//s.length();
		return "home";
	}
	
	//controler based exception handling
	/*@ExceptionHandler(value=NullPointerException.class)
	public String showError(Model model) {
		String errMsg="Something went wrong!!";
		model.addAttribute("errMsg", errMsg);
		return "errorPage";
	}*/
	
	@RequestMapping("/price")
	public String showBookPrice(@RequestParam("bid")String bookId,Model model) {
		Double price=service.findBookPrice(bookId);
		model.addAttribute("price",price);
		return "home";
	}
}
