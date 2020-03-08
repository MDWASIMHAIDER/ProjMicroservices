package com.example.constants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;


public interface AppConstants {
	public static final String Reg_Success="Register Successfull";
	//public staic final is bydefault
	String User_Reg_View="userRegistration";
	String Success_Result_Key="msg";
	String Failure_Result_Key="msg";
	String Country_List_Key="countrylist";
}
