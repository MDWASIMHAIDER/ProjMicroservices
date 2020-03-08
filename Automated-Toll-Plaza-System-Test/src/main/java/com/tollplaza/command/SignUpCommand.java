package com.tollplaza.command;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignUpCommand {
	private Integer signUpId;
	private String firstName;
	private String lastName;
	private String email;
	private Long phone;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date dob;
	private String gender;
	private String role="user";
	private String status="locked";
	private String pazzword;
	private String active_switch="Y";
	
	
}
