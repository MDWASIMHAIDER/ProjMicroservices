package com.tollplaza.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tollplaza.command.UpdateCommand;
import com.tollplaza.entity.UpdateEntity;
import com.tollplaza.service.UpdateService;

@Controller
@RequestMapping("/updateController")
public class UpdateController {
	
	@Autowired
	private UpdateService service;
	
	@GetMapping("/updateurl")
	public String showUpdateForm(@ModelAttribute("updatecmd")UpdateCommand cmd,Model model,HttpSession ses) {
		model.addAttribute("email",ses.getAttribute("email"));
		return "update";
		
	}
	
	@PostMapping("/updateurl")
	public String updateUser(@ModelAttribute("updatecmd")UpdateCommand cmd,Model model,HttpSession ses) {
		String tempPassword = (String) ses.getAttribute("temppassword");
		UpdateEntity entity=new UpdateEntity();
		UpdateEntity savePasswordUpdate=null;
		if(tempPassword.equals(cmd.getTempPassword())) {
			BeanUtils.copyProperties(cmd,entity);
			savePasswordUpdate = service.savePasswordUpdate(entity);
			if(savePasswordUpdate!=null) {
				model.addAttribute("Account Unlocked");
			}
		}
		
		return "update";
	}
}
