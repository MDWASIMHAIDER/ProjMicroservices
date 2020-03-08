package com.tollplaza.command;

import lombok.Data;

@Data
public class AdminLoginCommand {
	private String adminId;
	private String adminPassword;
}
