package com.tollplaza.service;

import org.springframework.stereotype.Service;

import com.tollplaza.entity.SignUpEntity;


public interface SignUpService {
	public SignUpEntity saveUser(SignUpEntity entity,String temporaryPassword);
}
