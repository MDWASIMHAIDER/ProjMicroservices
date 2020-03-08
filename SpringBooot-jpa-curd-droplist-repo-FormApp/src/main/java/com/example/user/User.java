package com.example.user;

import lombok.Data;

@Data
public class User {
	Integer serialNumber;
	private String uname;
	private String pazzword;
	private String email;
	private Long phone;
	private String countries;
	private String status;
}
