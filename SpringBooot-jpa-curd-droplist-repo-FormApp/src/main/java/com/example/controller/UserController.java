package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.PageData;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.command.UserCommand;
import com.example.constants.AppConstants;
import com.example.entity.UserEntity;
import com.example.properties.AppProperties;
import com.example.repository.UserRepository;
import com.example.user.User;

@Controller
public class UserController {
	
	@Autowired
	private AppProperties prop;
	@Autowired
	private UserRepository repo;
	
	/*@Autowired
	JdbcTemplate jt;*/
	
	@GetMapping("/regForm")
	//model intialization is must at the time of first form launch
	public String showForm(@ModelAttribute("ucmd")UserCommand cmd,Model model) {
		countryList(model);
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
	//public String processForm(@ModelAttribute("ucmd")UserCommand cmd,Map<String,Object>map,Model model) {
	public String processForm(@ModelAttribute("ucmd")UserCommand cmd,RedirectAttributes attribute) {
			
	//UserCommand cmd1=cmd;
		System.out.println(cmd);
		UserEntity user=new UserEntity();
		BeanUtils.copyProperties(cmd, user);
		//countryList(model);
		 List<String>list=new ArrayList();
	        list.add("India");
	        list.add("Pakistan");
	        list.add("Bangladesh");
	      //  map.put(AppConstants.Country_List_Key,list);
	      attribute.addFlashAttribute(AppConstants.Country_List_Key,list);
	        String msg1=prop.getMessage().get("regSucces");
	        String msg2=prop.getMessage().get("regFailure");
	        //here AppConstant interface is giving constant value
	        UserEntity ut=repo.save(user);
	        
	        if(ut.getSerialNumber()!=null) {
	        	// map.put(AppConstants.Success_Result_Key,msg1);
	  	      attribute.addFlashAttribute(AppConstants.Success_Result_Key,msg1);
	  	    
	        }
	        else {
	        	// map.put(AppConstants.Failure_Result_Key,msg2);
	        	 attribute.addFlashAttribute(AppConstants.Failure_Result_Key,msg2);
	 	  	    
	        }
	      //  return AppConstants.User_Reg_View;
	        return "redirect:/doublepost";
	}
	
	
	
	
	
	//this method is reusable..where we just call it where we needed 
	//model is used to send data to view layer
	private void countryList(Model model) {
		 List<String>list=new ArrayList();
	        list.add("India");
	        list.add("Pakistan");
	        list.add("Bangladesh");
	        model.addAttribute("countrylist",list);
	}
	
	
	
	
	//here doublepost url is action name which is used in redirect:/doublepost
	@RequestMapping(value={"/","doublepost"},method=RequestMethod.GET)
	public String doublePost(@ModelAttribute("ucmd")UserCommand cmd,Model model) {
		return AppConstants.User_Reg_View;
	}
	
	
	
	@GetMapping("/showAllRecord")
	public String getAllUser(Model model,@RequestParam("cpage")Integer currentPage) {
		//int ppage=1;
		int pageSize=3;
		//page alway works with array index start with 0 so -1 is used
		/*PageRequest page=PageRequest.of(currentPage-1, pageSize);
		Page<UserEntity>pagedata=repo.findAll(page);
		//Iterable<UserEntity> usersList = repo.findAll(page);
		List<UserEntity>list=pagedata.getContent();
		List<User>userlist=new ArrayList();
		for(UserEntity user:list) {
			User user1=new User();
			BeanUtils.copyProperties(user, user1);
			userlist.add(user1);
		}
		model.addAttribute("userList",userlist);
		model.addAttribute("pagesize",pageSize);
		model.addAttribute("currentpage",currentPage);
		*/ 
		
		
		
		PageRequest page=PageRequest.of(currentPage-1, pageSize);
		Page<UserEntity>pagedata= repo.findAllUser(page);
		List<UserEntity>list=pagedata.getContent();
		System.out.println(list);
		/*List<User>userlist=new ArrayList();
		for(UserEntity user:list) {
			User user1=new User();
			BeanUtils.copyProperties(user, user1);
			userlist.add(user1);
		}*/
		model.addAttribute("userList",list);
		model.addAttribute("pagesize",pageSize);
		model.addAttribute("currentpage",currentPage);
	
		return AppConstants.All_User_Detail;
	}
	
	
	
	@RequestMapping("/deleteUser")
	public String deleteUserRecordById(@RequestParam("uid")Integer uid) {
		
		repo.deactivateAccount(uid);
		/*repo.deleteById(uid);
		return "redirect:/showAllRecord?cpage=1";*/
		//return "redirect:/showAllRecord";
		return AppConstants.All_User_Detail;
	}
	
	
	@RequestMapping("/getemail")
	public @ResponseBody List<String>getEmails(){
		List<String> allEmails = repo.findallEmails();
		return allEmails;
	}
	
	@RequestMapping("/getsingleemail")
	public @ResponseBody String getSingleEmail(@RequestParam("sid")Integer uid) {
		String email=repo.findEmailById(uid);
		return email;
	}
	
	//here no need of model attribute("ucmd") in form to just put the in model
	//it will copy the data to the form
	@RequestMapping("/editUser")
	public String editUserRecord(Model model,@RequestParam("uid")Integer uid) {
		//optional means it may have value or not 
		Optional<UserEntity> user=repo.findById(uid);
		if(user.isPresent()) {
			UserEntity userEntity = user.get();
			User ucmd1=new User();
			BeanUtils.copyProperties(userEntity,ucmd1);
			model.addAttribute("usr",ucmd1);
			
		}
		countryList(model);
		return AppConstants.Edit_User_View;
	}
	
	
	
	@RequestMapping(value="/updateUser",method=RequestMethod.POST)
	public String updateUserRecord(@ModelAttribute("usr")UserEntity userEntity,@RequestParam("sid")Integer sid,Model model) {
		
		//UserEntity userEntity=new UserEntity();
		//BeanUtils.copyProperties(user,userEntity);
		userEntity.setSerialNumber(sid);
		UserEntity save =repo.save(userEntity); 
		
		
		if(save==null) {
			model.addAttribute("updateres","Record not Updated Successfull");
		}
		else {
			model.addAttribute("updateres","Record Updated Successfull");
			
		}
		return AppConstants.Edit_User_View;
	}
}
