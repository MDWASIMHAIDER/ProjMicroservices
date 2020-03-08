package com.example.command;

import lombok.Data;

@Data
public class UserCommand {
	private String uname;
	private String pazzword;
	private String email;
	private Long phone;
	private String countries;
}
