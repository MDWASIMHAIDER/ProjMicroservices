package com.tollplaza.command;

import java.util.Date;

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
}
