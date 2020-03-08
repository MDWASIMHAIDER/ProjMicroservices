package com.example.command;

import lombok.Data;

@Data
public class UserCommand {
	Integer serialNumber;
	private String uname;
	private String pazzword;
	private String email;
	private Long phone;
	private String countries;
	private String status;
}
