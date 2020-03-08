package com.tollplaza.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tollplaza.command.LoginCommand;
import com.tollplaza.command.UpdateCommand;
import com.tollplaza.entity.AdminAgencyEntity;
import com.tollplaza.entity.SignUpEntity;
import com.tollplaza.service.AdminService;
import com.tollplaza.service.SignUpService;

@Controller
@RequestMapping("/updateController")
public class UpdateController {

	@Autowired
	private SignUpService service;
	
	@Autowired
	private AdminService adminService;

	@GetMapping("/updateurl")
	public String showUpdateForm(@ModelAttribute("updatecmd") UpdateCommand cmd, Model model, HttpSession ses,
			@RequestParam("emailId") String email,@RequestParam("role")String role) {
		// model.addAttribute("email", ses.getAttribute("email"));
		model.addAttribute("email", email);
		model.addAttribute("role",role);
		return "update";

	}

	@PostMapping("/updateurl")
	public String updateUser(@ModelAttribute("updatecmd") UpdateCommand cmd, Model model, HttpSession ses,
			RedirectAttributes attr) {
		String mail = cmd.getEmail();
		String role = cmd.getRole();
		if(role.equals("User")) {
			System.out.println("user block ==============================");
			SignUpEntity userByEmail = service.getUserByEmail(mail);
			String tempPassword = userByEmail.getPazzword();
			//String status = userByEmail.getStatus();
			String temppwd = (String) attr.getAttribute("temp");
			String tempPassword2 = cmd.getTempPassword();
			String newPassword = cmd.getNewPassword();
			String confirmPassword = cmd.getConfirmPassword();
			SignUpEntity savePasswordUpdate = null;
			String matcher = null;
			if (tempPassword.equals(temppwd)) {
				matcher = temppwd;
			} else {
				matcher = tempPassword;
			}
			System.out.println(tempPassword + "==" + matcher + "&&" + newPassword + "==" + confirmPassword);
			if (tempPassword.equals(matcher) && newPassword.equals(confirmPassword)) {
				savePasswordUpdate = service.savePasswordUpdate("Unlocked", cmd.getEmail(), cmd.getNewPassword());
				if (savePasswordUpdate != null) {
					model.addAttribute("Unlocked", "Account Unlocked");
				}
			}
		}
		
		else if(role.equals("Agency")) {
			AdminAgencyEntity agencyByEmail = adminService.getAgencyByEmail(mail);
			String tempPassword = agencyByEmail.getPazzword();
			//String status = userByEmail.getStatus();
			String temppwd = (String) attr.getAttribute("temp");
			String tempPassword2 = cmd.getTempPassword();
			String newPassword = cmd.getNewPassword();
			String confirmPassword = cmd.getConfirmPassword();
			String matcher = null;
			if (tempPassword.equals(temppwd)) {
				matcher = temppwd;
			} else {
				matcher = tempPassword;
			}
			System.out.println(tempPassword + "==" + matcher + "&&" + newPassword + "==" + confirmPassword);
			if (tempPassword.equals(matcher) && newPassword.equals(confirmPassword)) {
				Integer savePasswordUpdate = adminService.savePasswordUpdate("Unlocked", cmd.getEmail(), cmd.getNewPassword());
				if (savePasswordUpdate == 1) {
					model.addAttribute("Unlocked", "Account Unlocked");
				}
			}
		}
		model.addAttribute("logincmd",new LoginCommand());
		return "redirect:/logincontroller/showlogin";
	}

}
