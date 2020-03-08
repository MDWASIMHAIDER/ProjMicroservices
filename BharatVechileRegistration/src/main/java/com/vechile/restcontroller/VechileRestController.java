package com.vechile.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VechileRestController {
	
	@GetMapping(name="/getvechile",produces= {"application/json","application/xml"})
	public String showOwner(@RequestParam("oid")String id) {
		
		return null;
	}
}
