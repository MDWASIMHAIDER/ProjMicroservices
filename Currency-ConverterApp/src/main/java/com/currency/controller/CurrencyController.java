package com.currency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.currency.command.CurrencyCommand;
import com.currency.resbean.ResponseBean;
import com.currency.service.CurrencyService;

@Controller
//@RequestMapping("/costcontroller")
public class CurrencyController {
	
	@Autowired
	private CurrencyService service;
	
	@GetMapping("/totalcost")
	public String showHome(@ModelAttribute("ccmd")CurrencyCommand cmd) {
		return "converterpage";
	}
	@PostMapping("/cost")
	public String showTotalCost(@ModelAttribute("ccmd")CurrencyCommand cmd,Model model) {
		String from=cmd.getFrom();
		String to=cmd.getTo();
		Double amt=cmd.getAmountQuantity();
		//System.out.println("ready to call fien client"+from+" "+to+""+amt);
		ResponseEntity<ResponseBean> responseEntity = service.callConveter(from,to,amt);
		ResponseBean body = responseEntity.getBody();
		Double totalCost = body.getTotalCost();
		model.addAttribute("totalCost",totalCost);
		return "converterpage";
	}
	
}
