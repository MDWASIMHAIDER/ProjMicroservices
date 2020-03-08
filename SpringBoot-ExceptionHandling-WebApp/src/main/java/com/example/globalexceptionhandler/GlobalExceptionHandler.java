package com.example.globalexceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.uexception.UserDefineException;

@ControllerAdvice
@Controller
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=NullPointerException.class)
	public String handleException(Model model) {
		String errMsg="Global Exception Occured Something went wrong";
		model.addAttribute("errMsg", errMsg);
		return "errorPage";
	}
	
	@ExceptionHandler(value=UserDefineException.class)
	public String handleUserDefineException() {
		return"UserErrorPage";
	}
}
