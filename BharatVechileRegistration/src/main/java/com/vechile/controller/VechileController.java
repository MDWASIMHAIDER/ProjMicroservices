package com.vechile.controller;

import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vechile.command.RegistrationCommand;
import com.vechile.command.VechileDetailCommand;
import com.vechile.command.VechileOwnerAddressCommand;
import com.vechile.command.VechileOwnerDetailCommand;
import com.vechile.entity.VechileEntity;
import com.vechile.entity.AddressEntity;
import com.vechile.entity.OwnerEntity;
import com.vechile.entity.RegistrationEntity;
import com.vechile.repository.RegistrationRepo;
import com.vechile.repository.VechileDetailRepository;
import com.vechile.repository.VechileOwnerAddressRepository;
import com.vechile.repository.VechileRepository;

@Controller
public class VechileController {
	
	
	@Autowired
	private VechileOwnerAddressRepository repo;
	
	@Autowired
	private VechileDetailRepository repo1;
	
	@Autowired
	private VechileRepository repo2;
	
	@Autowired
	private RegistrationRepo regrepo;
	
	public VechileController() {
		System.out.println("VechileController.VechileController()");
	}
	@RequestMapping(value="/user",method=RequestMethod.GET )
	public String showForm(@ModelAttribute("vodcmd")VechileOwnerDetailCommand entity) {
		return "vechileOwnerDetail";
	}
	
	@RequestMapping(value="/vechileDetail",method=RequestMethod.POST)
	public String userDetail(@ModelAttribute("vodcmd") VechileOwnerDetailCommand vcmd,Model model,HttpSession ses) {
		OwnerEntity entity=new OwnerEntity();
		BeanUtils.copyProperties(vcmd, entity);
		OwnerEntity ownerEntity = repo2.save(entity);
		//String resultMsg = dao.registerVechile(entity);
		//model.addAttribute("ownerEntity",ownerEntity);
		//int vechile_Owner_Id = res.getVechile_Owner_Id();
		ses.setAttribute("ownerEntity",ownerEntity);
		model.addAttribute("voadcmd", new VechileOwnerAddressCommand());
		return "vechileOwnerAddressDetail";
	}
	
	@RequestMapping(value="/ownerdetail",method=RequestMethod.POST)
	public String showOwnerAddress(@ModelAttribute("voadcmd")VechileOwnerAddressCommand cmd,Model model,HttpSession ses) {
		AddressEntity entity=new AddressEntity();
		BeanUtils.copyProperties(cmd, entity);
		System.out.println(ses);
		OwnerEntity ownerEntity = (OwnerEntity) ses.getAttribute("ownerEntity");
		//Optional<OwnerEntity> optional = repo2.findById(oid);
		//OwnerEntity vechileOwnerDetailEntity = optional.get();
		entity.setDetail(ownerEntity);
		 repo.save(entity);
		//int address_id = res.getAddress_id();
		//ses.setAttribute("ownerEntity",ownerEntity);
		model.addAttribute("vdcmd",new VechileDetailCommand());
		return "vechileDetail";
	}
	
	
	@PostMapping("/vechiledtl")
	public String showVechileDetail(@ModelAttribute("vdcmd")VechileDetailCommand cmd,Model model,HttpSession ses) {
		VechileEntity entity=new VechileEntity();
		BeanUtils.copyProperties(cmd, entity);
		OwnerEntity ownerEntity=(OwnerEntity) ses.getAttribute("ownerEntity");
		//Optional<OwnerEntity> optional = repo2.findById(aid);
		//OwnerEntity vechileOwnerAddressDetailsEntity = optional.get();
		
		entity.setDetail(ownerEntity);
		
		VechileEntity vechileEntity = repo1.save(entity);
		//ses.setAttribute("ownerEntity",ownerEntity);
		model.addAttribute("rgcmd", new RegistrationCommand());
		return "result";
	}
	
	
	@PostMapping("/regdtl")
	public String registrationDetail(@ModelAttribute("rgcmd")RegistrationCommand cmd,HttpSession ses,Model model) {
		RegistrationEntity entity=new RegistrationEntity();
		BeanUtils.copyProperties(cmd, entity);
		String s="US-";
		Random rad1=new Random();
		Random rad2=new Random();
		int firstvalue = rad1.nextInt(100);
		int secondvalue = rad2.nextInt(1000);
		StringBuffer sb=new StringBuffer(s);
		sb.append(firstvalue);
		sb.append("-TX-");
		sb.append(secondvalue);
		String s1=sb.toString();
		entity.setVechile_Reg_Num(s1);
		OwnerEntity ownerEntity = (OwnerEntity) ses.getAttribute("ownerEntity");
		entity.setDetail(ownerEntity);
		RegistrationEntity registrationEntity = regrepo.save(entity);
		return "result";
		
	}
}
