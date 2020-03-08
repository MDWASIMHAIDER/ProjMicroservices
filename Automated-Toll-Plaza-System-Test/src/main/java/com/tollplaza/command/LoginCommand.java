package com.tollplaza.command;

import lombok.Data;

@Data
public class LoginCommand {
	private String clientId;
	private String clientPassword;
}
