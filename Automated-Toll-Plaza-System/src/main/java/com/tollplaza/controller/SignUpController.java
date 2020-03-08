package com.tollplaza.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tollplaza.command.SignUpCommand;
import com.tollplaza.entity.SignUpEntity;
import com.tollplaza.service.SignUpService;

@Controller
@RequestMapping("/signupcontroller")
public class SignUpController {
	
	@Autowired
	private SignUpService service;
	
	@GetMapping("/signup")
	public String showSignUpForm(@ModelAttribute("signupcmd")SignUpCommand cmd,Model model,HttpSession ses) {
		String temporaryPassowrd = (String) ses.getAttribute("temppassword");
		
			List<String>genderlist=new ArrayList();
			genderlist.add("Male");
			genderlist.add("Female");
			model.addAttribute("genderlist", genderlist);
	
			model.addAttribute("temporaryPassowrd", ses.getAttribute("temppassword"));
			ses.removeAttribute("temppassword");
		
		return "signup";
	}
	
	public String createTemporaryPassword() {
		Random rad1 = new Random();
		Random rad2 = new Random();
		int fistValue = rad1.nextInt(1000);
		int secondValue = rad2.nextInt(100);
		String infixValue = "ATPS";
		String tempPassword = fistValue + infixValue + secondValue;
		return tempPassword;
	}
	
	@PostMapping("/signupurl")
	public String ProcessSignUpForm(@ModelAttribute("signupcmd")SignUpCommand cmd,
										Model model,HttpSession ses) {
		SignUpEntity entity=new SignUpEntity();
		BeanUtils.copyProperties(cmd, entity);
		String tempPassword=createTemporaryPassword();
		ses.setAttribute("temppassword",tempPassword );
		SignUpEntity saveUser = service.saveUser(entity,tempPassword);
		String email = saveUser.getEmail();
		ses.setAttribute("email",email);
		return "redirect:/signupcontroller/signup";
	}
}

