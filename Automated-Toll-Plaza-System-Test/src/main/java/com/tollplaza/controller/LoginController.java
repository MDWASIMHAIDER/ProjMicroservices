package com.tollplaza.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpStatusCodeException;

import com.tollplaza.bindings.Summary;
import com.tollplaza.command.LoginCommand;
import com.tollplaza.entity.SignUpEntity;
import com.tollplaza.pazzwordencoder.PazzwordEncoderAndEncryption;
import com.tollplaza.service.SignUpService;

@Controller
@RequestMapping("/logincontroller")
public class LoginController {

	@Autowired
	private SignUpService service;

	@GetMapping("/showlogin")
	public String showLoginForm(@ModelAttribute("logincmd") LoginCommand cmd) {
		return "login";
	}

	@PostMapping("/loginurl")
	public String processLoginForm(@ModelAttribute("logincmd") LoginCommand cmd, Model model,HttpSession ses) {
		String uid = cmd.getClientId();
		String pwd = cmd.getClientPassword();
		SignUpEntity userByEmail = service.getUserByEmail(uid);
		String email = userByEmail.getEmail();
		String status = userByEmail.getStatus();
		String pazzword = userByEmail.getPazzword();
		Integer signUpId = userByEmail.getSignUpId();
		String firstName = userByEmail.getFirstName();
		String lastName = userByEmail.getLastName();
		ses.setAttribute("signUpId", signUpId);
		String fullName=firstName+" "+lastName;
		ses.setAttribute("fullName",fullName);
		if (status.equals("Unlocked") ) {
			if(uid.equals(email) && pwd.equals(pazzword)) {
				model.addAttribute("Account", "Work in progress Please Keep patient");
				model.addAttribute("signUpId",signUpId);
				model.addAttribute("fullName",fullName);
			}
			else {
				model.addAttribute("locked", "Password did not matched ");
				return "login";
			}
			
			return "dashboard";
		}
		else if(status.equals("locked")){
			model.addAttribute("locked", "Plz Unlock your Account First");
			return "login";
		}
		return "login";
	}
	
	@GetMapping("/dashurl")
	public String showDashBoard() {
		/*ses.removeAttribute("signUpId");
		ses.invalidate();*/
	
		return "login";
	}
	
	
}
