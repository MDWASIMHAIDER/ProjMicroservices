package com.tollplaza.temporarypasswordgnerartor;

import java.util.Random;

import lombok.Data;

@Data
public class PasswordGenerator {
	
	public static String createTemporaryPassword() {
		Random rad1 = new Random();
		Random rad2 = new Random();
		int fistValue = rad1.nextInt(1000);
		int secondValue = rad2.nextInt(100);
		String infixValue = "ATPS";
		String tempPassword = fistValue + infixValue + secondValue;
		return tempPassword;
	}
}
