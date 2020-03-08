package com.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class WelcomeController {
	
	private static final Logger log=LoggerFactory.getLogger(WelcomeController.class);
	
	
	@GetMapping("/msg")
	public String getMsg() {
		  log.info("get() started");
		  String msg="welcome wasim";
		  log.info("get() ended");
		return msg;
	}
}
