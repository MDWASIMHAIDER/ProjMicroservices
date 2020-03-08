package com.tollplaza.command;

import lombok.Data;

@Data
public class UpdateCommand {
	
	private Integer updateId;
	private String email;
	private String tempPassword;
	private String newPassword;
	private String confirmPassword;
}
