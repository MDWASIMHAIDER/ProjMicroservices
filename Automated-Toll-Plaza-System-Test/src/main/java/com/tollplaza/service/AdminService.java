package com.tollplaza.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tollplaza.entity.AdminAgencyEntity;
import com.tollplaza.entity.AdminLoginEntity;
import com.tollplaza.entity.SignUpEntity;


public interface AdminService {
	public AdminLoginEntity saveAdmin(AdminLoginEntity entity);
	public Integer authenticateAdmin(AdminLoginEntity entity);
	public AdminAgencyEntity addNewAgency(AdminAgencyEntity entity,String tempPazzword);
	public Integer findAdminAgencyByEmail(String email);
	public Integer savePasswordUpdate(String status, String pwd, String email);
	public AdminAgencyEntity getAgencyByEmail(String email);
	public List<AdminAgencyEntity> getAllAgencyDetails();
	public List<SignUpEntity> getAllUserDetails();
	public Integer deactivateAgency(String email,String val);
	public Integer activateAgency(String email,String val);
	
}
