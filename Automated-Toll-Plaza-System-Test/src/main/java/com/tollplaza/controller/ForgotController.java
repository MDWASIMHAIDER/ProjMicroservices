package com.tollplaza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tollplaza.command.ForgotCommand;
import com.tollplaza.emailsender.EmailSender;
import com.tollplaza.entity.SignUpEntity;
import com.tollplaza.service.SignUpService;
import com.tollplaza.temporarypasswordgnerartor.PasswordGenerator;

@Controller
@RequestMapping("/forgoturl")
public class ForgotController {
	
	@Autowired
	private SignUpService service;
	
	@Autowired
	private EmailSender emailSender;
	
	@GetMapping("/forgotpage")
	public String showForgotPage(@ModelAttribute("forgotcmd")ForgotCommand cmd) {
		return "forgot";
	}
	
	@PostMapping("/forgotpassword")
	public String updateForgotPage(@ModelAttribute("forgotcmd")ForgotCommand cmd,Model model) {
		String clientId=cmd.getClientId();
		String temporaryPassword = PasswordGenerator.createTemporaryPassword();
		SignUpEntity userByEmail = service.getUserByEmail(clientId);
		String role = userByEmail.getRole();
		if(userByEmail!=null) {
			//service.saveForgotPasswordUpdate(pwd, email)
			emailSender.sendEmail(clientId, temporaryPassword,role);
			//attr.addFlashAttribute("temp",temporaryPassword);
			model.addAttribute("emailstatus","Email Found(Password has sent to your Email Id)");
			//return "/updateController/updateurl";
			//return "redirect:/updateController/updateurl";
			return "forgot";
		}
		else {
			model.addAttribute("emailstatus","Email Not Found");
			return "forgot";
		}
		
	}

}
