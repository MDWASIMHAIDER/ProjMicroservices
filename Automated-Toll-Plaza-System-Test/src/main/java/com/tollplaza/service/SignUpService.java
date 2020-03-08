package com.tollplaza.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tollplaza.bindings.Summary;
import com.tollplaza.entity.SignUpEntity;


public interface SignUpService {
	public SignUpEntity saveUser(SignUpEntity entity,String temporaryPassword);
	public SignUpEntity savePasswordUpdate(String status,String pwd,String email);
	public SignUpEntity getUserByEmail(String mail);
	public SignUpEntity saveForgotPasswordUpdate(String pwd,String email);
	public Integer findByEmail(String email);
	public Integer deactivateUser(String email,String val);
	public Integer activateUser(String email,String val);
	public ResponseEntity<Summary> getVechileDetails(String regNo);
}
