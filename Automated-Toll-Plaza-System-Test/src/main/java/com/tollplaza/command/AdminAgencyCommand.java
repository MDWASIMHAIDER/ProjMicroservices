package com.tollplaza.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
public class AdminAgencyCommand {
	private String agencyName;
	private String ownerName;
	private String city;
	private String email;
	private Long phone;
	private String gender;
	private Integer pin;
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date dob;
	private String role="Agency";
	private String status="Locked";
	private String pazzword;
	private Date create_Date;
	private Date update_Date;
	private String active_Switch="Y";
	
}
