package com.tollplaza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tollplaza.emailsender.EmailSender;
import com.tollplaza.entity.AdminAgencyEntity;
import com.tollplaza.entity.AdminLoginEntity;
import com.tollplaza.entity.SignUpEntity;
import com.tollplaza.repository.AdminAgencyRepository;
import com.tollplaza.repository.AdminRepository;
import com.tollplaza.repository.SignUpRepository;
import com.tollplaza.temporarypasswordgnerartor.PasswordGenerator;


@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository repo;
	
	@Autowired
	private AdminAgencyRepository agencyRepo;
	
	@Autowired
	private SignUpRepository signUpRepository;
	
	@Autowired
	private EmailSender sender;
	
	@Override
	public AdminLoginEntity saveAdmin(AdminLoginEntity entity) {
		AdminLoginEntity adminLoginEntity = repo.save(entity);
		return adminLoginEntity;

	}

	@Override
	public Integer authenticateAdmin(AdminLoginEntity entity) {
		String adminId=null;
		String adminPassword=null;
		adminId=entity.getAdminId();
		adminPassword=entity.getAdminPassword();
		Integer authenticateAdminDetails = repo.authenticateAdminDetails(adminId, adminPassword);
		return authenticateAdminDetails;
	}

	@Override
	public AdminAgencyEntity addNewAgency(AdminAgencyEntity entity,String tempPazzword) {
		AdminAgencyEntity adminAgencyEntity = agencyRepo.save(entity);
		String role = adminAgencyEntity.getRole();
		String email=adminAgencyEntity.getEmail();
		sender.sendEmail(email, tempPazzword,role);
		return adminAgencyEntity;
	}

	@Override
	public Integer findAdminAgencyByEmail(String email) {
		 Integer searchAdminAgencyByEmailId = agencyRepo.searchAdminAgencyByEmailId(email);
		return searchAdminAgencyByEmailId;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Integer savePasswordUpdate(String status, String pwd, String email) {
		Integer res = agencyRepo.updateUserDetail(status, email, pwd);
		return res;
	}

	@Override
	public AdminAgencyEntity getAgencyByEmail(String email) {
		
		AdminAgencyEntity agencyDetailByEmail = agencyRepo.getAgencyDetailByEmail(email);
		return agencyDetailByEmail;
	}

	@Override
	public List<AdminAgencyEntity> getAllAgencyDetails() {
		List<AdminAgencyEntity> findAll = agencyRepo.findAll();
		return findAll;
	}

	@Override
	public List<SignUpEntity> getAllUserDetails() {
		List<SignUpEntity> list = signUpRepository.findAll();
		return list;
	}

	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Integer deactivateAgency(String email, String val) {
		Integer deactivateAgency = agencyRepo.deactivateAgency(email, val);
		return deactivateAgency;
	}

	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Integer activateAgency(String email, String val) {
		Integer activateAgency = agencyRepo.activateAgency(email, val);
		return activateAgency;
	}


}
