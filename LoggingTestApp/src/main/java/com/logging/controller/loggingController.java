package com.logging.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loggingController {
	static Logger logg=(Logger) LoggerFactory.getLogger(loggingController.class);
	
	@RequestMapping("/")
	public String showLogs() {
		int a=10;
		try {
			int b=a/0;
		}
		catch(RuntimeException e){
			logg.info("this is info",e);
		}
		logg.trace("A TRACE Message");
        logg.debug("A DEBUG Message");
        logg.info("An INFO Message");
        logg.warn("A WARN Message");
        logg.error("An ERROR Message");
 
        return "Howdy! Check out the Logs to see the output...";
	}
}
