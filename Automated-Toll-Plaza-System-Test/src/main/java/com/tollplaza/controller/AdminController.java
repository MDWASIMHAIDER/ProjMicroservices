package com.tollplaza.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tollplaza.command.AdminAgencyCommand;
import com.tollplaza.command.AdminLoginCommand;
import com.tollplaza.entity.AdminAgencyEntity;
import com.tollplaza.entity.AdminLoginEntity;
import com.tollplaza.entity.SignUpEntity;
import com.tollplaza.service.AdminService;
import com.tollplaza.temporarypasswordgnerartor.PasswordGenerator;

@Controller
@RequestMapping("/adminController")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@GetMapping("/admin")
	public String showAdmin(@ModelAttribute("adminlogincmd")AdminLoginCommand cmd) {
		return "adminlogin";
	}
	
	@PostMapping("/loginurl")
	public String processAdmin(@ModelAttribute("adminlogincmd")AdminLoginCommand cmd,Model model) {
		AdminLoginEntity entity=new AdminLoginEntity();
		BeanUtils.copyProperties(cmd, entity);
		Integer authenticateAdmin = service.authenticateAdmin(entity);
		if(authenticateAdmin>0) {
			return "admin";
		}
		else {
			model.addAttribute("unauthorized","Wrong Credentials");
			return "adminlogin";
		}
	}
	
	@GetMapping("/agencyForm")
	public String showCreateAgencyForm(@ModelAttribute("agencycmd")AdminAgencyCommand cmd,Model model) {
		List<String>list=new ArrayList();
		list.add("Admin");
		list.add("Agency");
		list.add("User");
		List<String>list1=new ArrayList();
		list1.add("Male");
		list1.add("Female");
		model.addAttribute("accountroles",list);
		model.addAttribute("genderlist",list1);
		return "agency";
	}
	
	@PostMapping("/agencyurl")
	public String saveAgency(@ModelAttribute("agencycmd")AdminAgencyCommand cmd,Model model) {
		AdminAgencyEntity entity=new AdminAgencyEntity();
		BeanUtils.copyProperties(cmd, entity);
		String createTemporaryPassword = PasswordGenerator.createTemporaryPassword();
		entity.setPazzword(createTemporaryPassword);
		AdminAgencyEntity newAgency = service.addNewAgency(entity,createTemporaryPassword);
		
		return "admin";
	}
	
	@GetMapping("/allAgencyDetail")
	public String getAllAgencyDetails(Model model) {
		List<AdminAgencyEntity> getAllAgencyDetails = service.getAllAgencyDetails();
		List<String>roleList=new ArrayList();
		roleList.add("Deactive");
		roleList.add("Active");
		model.addAttribute("getAllAgencyDetails",getAllAgencyDetails);
		model.addAttribute("roleList",roleList);
		return "admin";
	}
	
	@GetMapping("/allUserDetail")
	public String getAllUserDetails(Model model) {
		List<SignUpEntity> allUserDetails = service.getAllUserDetails();
		model.addAttribute("allUserDetails",allUserDetails);
		return "admin";
	}
	
	@GetMapping("/activateagency")
	public String activateAgency(@RequestParam("emailId")String email) {
		Integer activateAgency = service.activateAgency(email, "Y");
		return "admin";
	}
	
	@GetMapping("/deactivateagency")
	public String deactivateAgency(@RequestParam("emailId")String email) {
		Integer activateAgency = service.activateAgency(email, "N");
		return "admin";
	}
}
