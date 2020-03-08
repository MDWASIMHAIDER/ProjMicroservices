package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.command.UserCommand;
import com.example.constants.AppConstants;
import com.example.entity.UserEntity;
import com.example.properties.AppProperties;
import com.example.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private AppProperties prop;
	@Autowired
	private UserRepository repo;
	
	@GetMapping("/regForm")
	//model intialization is must at the time of first form launch
	public String showForm(@ModelAttribute("ucmd")UserCommand cmd,Model model) {
		//countryList(model);
		List<String>list=new ArrayList();
        list.add("India");
        list.add("Pakistan");
        list.add("Bangladesh");
        model.addAttribute(AppConstants.Country_List_Key,list);
		return AppConstants.User_Reg_View;
	}
	
	//1st approach
	/*@PostMapping("/regForm")
	public String processForm(@ModelAttribute("ucmd")UserCommand cmd,Map<String,String>map,Model model) {
		//UserCommand cmd1=cmd;
		System.out.println(cmd);
		countryList(model);
		map.put("msg","Register Successfull");
		return "userRegistration";
	}*/
	
	//2nd approach
	@PostMapping("/regForm")
	public String processForm(@ModelAttribute("ucmd")UserCommand cmd,Map<String,Object>map,Model model) {
		//UserCommand cmd1=cmd;
		System.out.println(cmd);
		UserEntity user=new UserEntity();
		BeanUtils.copyProperties(cmd, user);
		
		//countryList(model);
		 List<String>list=new ArrayList();
	        list.add("India");
	        list.add("Pakistan");
	        list.add("Bangladesh");
	        map.put(AppConstants.Country_List_Key,list);
	        String msg1=prop.getMessage().get("regSucces");
	        String msg2=prop.getMessage().get("regFailure");
	        //here AppConstant interface is giving constant value
	        UserEntity ut=repo.save(user);
	        
	        if(ut.getSerialNumber()!=null) {
	        	 map.put(AppConstants.Success_Result_Key,msg1);
	        }
	        else {
	        	 map.put(AppConstants.Failure_Result_Key,msg2);
	        }
	       
	        return AppConstants.User_Reg_View;
	}
	
	//this method is reusable..where we just call it where we needed 
	//model is used to send data to view layer
	/*private void countryList(Model model) {
		 List<String>list=new ArrayList();
	        list.add("India");
	        list.add("Pakistan");
	        list.add("Bangladesh");
	        //map.put("countrylist", list);
	        model.addAttribute("countrylist",list);
	}*/
}
