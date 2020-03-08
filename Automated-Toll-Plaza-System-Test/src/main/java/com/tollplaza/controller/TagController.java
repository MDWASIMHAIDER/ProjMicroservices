package com.tollplaza.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
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
import com.tollplaza.command.TagMasterCommand;
import com.tollplaza.entity.TagMasterEntity;
import com.tollplaza.rtoservice.TollPlazaRtoService;
import com.tollplaza.rtovechiledata.AddressEntity;
import com.tollplaza.rtovechiledata.OwnerEntity;
import com.tollplaza.rtovechiledata.RegistrationEntity;
import com.tollplaza.rtovechiledata.VechileEntity;
import com.tollplaza.service.SignUpService;
import com.tollplaza.service.TagService;

@Controller
@RequestMapping("tagcontroller")
public class TagController {
	
	@Autowired
	private SignUpService service;
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private TollPlazaRtoService rtoService;
	
	@GetMapping("/purchasetag")
	public String showPurchaseTag(Model model) {
		model.addAttribute("pclicked","pclicked");
		return "dashboard";
	}
	
	@GetMapping("/mytag")
	public String showMyTag(Model model) {
		model.addAttribute("mytagclicked","pclicked");
		return "dashboard";
	}
	
	@PostMapping("/regurl")
	public String getRegNumber(HttpServletRequest req,Model model,@ModelAttribute("tagcmd")TagMasterCommand cmd) {
		String regNo = req.getParameter("regNo");
		int statusCodeValue=0;
		OwnerEntity ownerEntity=new OwnerEntity();
		AddressEntity addressEntity=new AddressEntity();
		RegistrationEntity registrationEntity=new RegistrationEntity();
		VechileEntity vechileEntity=new VechileEntity();
		try {
		ResponseEntity<Summary> responseEntity = service.getVechileDetails(regNo);
		statusCodeValue = responseEntity.getStatusCodeValue();
		System.out.println(statusCodeValue);
		Summary vechileDetails = responseEntity.getBody();
		com.tollplaza.bindings.OwnerEntity owner = vechileDetails.getOwner();
		com.tollplaza.bindings.AddressEntity address = vechileDetails.getAddress();
		com.tollplaza.bindings.VechileEntity vechile = vechileDetails.getVechile();
		com.tollplaza.bindings.RegistrationEntity registration = vechileDetails.getRegistration();
		BeanUtils.copyProperties(owner,ownerEntity);
		BeanUtils.copyProperties(address, addressEntity);
		BeanUtils.copyProperties(vechile, vechileEntity);
		BeanUtils.copyProperties(registration,registrationEntity);
		
		OwnerEntity saveOwner = rtoService.saveOwner(ownerEntity);
		AddressEntity saveAddress = rtoService.saveAddress(addressEntity);
		VechileEntity saveVechile = rtoService.saveVechile(vechileEntity);
		RegistrationEntity saveReg = rtoService.saveReg(registrationEntity);
		
		model.addAttribute("vechileDetails", vechileDetails);
		}
		catch(HttpStatusCodeException e) {
			model.addAttribute("statusCodeValue", "Invalid Registration Number");
		}
		model.addAttribute("cmd",new TagMasterCommand());
		return "vechilesearch";
	}
	
	@GetMapping("/purchasetagurl")
	public String showPurchaseTagForm(Model model,@ModelAttribute("tagcmd")TagMasterCommand cmd) {
		model.addAttribute("pclicked","pclicked");
		//TagMasterEntity entity=new TagMasterEntity();
		//BeanUtils.copyProperties(cmd, entity);
		//tagService.saveTagsDetails(entity);
		return "vechilesearch";
	}
	
	@PostMapping("/tagurl")
	public String processPurchaseTagForm(Model model,@ModelAttribute("tagcmd")TagMasterCommand cmd) {
		model.addAttribute("pclicked","pclicked");
		TagMasterEntity entity=new TagMasterEntity();
		BeanUtils.copyProperties(cmd, entity);
		String vechileRegNumber = entity.getVechileRegNumber();
		Integer findTagByVechileRegNo = tagService.findTagByVechileRegNo(vechileRegNumber);
		if(findTagByVechileRegNo==0) {
			
			tagService.saveTagsDetails(entity);
			//return "purchase";
		}
		else {
			model.addAttribute("availabltag","Tag allready associated with Reg No");
		}
		return "dashboard";
	}
	
}
