package com.batches;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.batches.atsbatches.Low_Bal_Reminder_Daily;

@SpringBootApplication
public class AtsBatchesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(AtsBatchesApplication.class, args);
		Low_Bal_Reminder_Daily bean = applicationContext.getBean(Low_Bal_Reminder_Daily.class);
		bean.test();
	}

}
