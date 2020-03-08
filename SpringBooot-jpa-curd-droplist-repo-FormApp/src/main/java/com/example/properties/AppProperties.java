package com.example.properties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@EnableConfigurationProperties
@ConfigurationProperties(prefix="formapp")
@Component
public class AppProperties {
	public AppProperties() {
		System.out.println("AppProperties.AppProperties()");
	}
	//this class bind the proprties file to the map as key value pair
	private Map<String,String>message=new HashMap();
}
