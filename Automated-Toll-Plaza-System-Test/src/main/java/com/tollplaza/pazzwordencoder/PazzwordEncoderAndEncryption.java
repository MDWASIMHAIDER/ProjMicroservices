package com.tollplaza.pazzwordencoder;


import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import lombok.Data;

@Data
public class PazzwordEncoderAndEncryption {
	//here key and vector must be of 16 length with any alphabets 
	private static final String key="aesEncryptionKey";
	private static final String initVector="encryptionIntVec";
	
	public static String encodePazzword(String value) {
		try {
				IvParameterSpec iv=new IvParameterSpec(initVector.getBytes("UTF-8"));
				SecretKeySpec skeySpec=new SecretKeySpec(key.getBytes("UTF-8"),"AES");
				Cipher cipher=Cipher.getInstance("AES/CBC/PKCS5PADDING");
				cipher.init(Cipher.ENCRYPT_MODE,skeySpec,iv);
				byte[] encrypted = cipher.doFinal(value.getBytes());
				String encodedValue = Base64.getEncoder().encodeToString(encrypted);
				return encodedValue;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	public static String deCodePazzword(String value) {
		try {
			IvParameterSpec iv=new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec=new SecretKeySpec(key.getBytes("UTF-8"),"AES");
			Cipher cipher=Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE,skeySpec,iv);
			byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(value));
			return new String(decrypted);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
}
