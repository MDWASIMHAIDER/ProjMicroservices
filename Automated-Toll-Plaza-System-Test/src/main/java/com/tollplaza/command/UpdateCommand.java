package com.tollplaza.command;

import lombok.Data;

@Data
public class UpdateCommand {
	
	private String email;
	private String role;
	private String tempPassword;
	private String newPassword;
	private String confirmPassword;
}
