package com.schedular;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MySchedular {
	
	@Scheduled(fixedRate=5000)
	public void run() throws Exception {
		System.out.println("fixed delay");
		Thread.sleep(3000);
	}
}
