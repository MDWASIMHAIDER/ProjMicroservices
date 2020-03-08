package com.tollplaza.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.tollplaza.bindings.Summary;
import com.tollplaza.emailsender.EmailSender;
import com.tollplaza.entity.SignUpEntity;
import com.tollplaza.repository.SignUpRepository;

@Service
public class SignUpServiceImpl implements SignUpService {

	/*
	 * @Autowired private JavaMailSender javaMailSender;
	 */
	
	@Autowired
	private RestTemplate restTemplate;
	
	ResponseEntity<Summary> responseEntity;
	
	@Autowired
	private SignUpRepository repo;

	@Autowired
	private EmailSender emailSender;

	Logger log = LoggerFactory.getLogger(SignUpService.class);

	@Override
	public SignUpEntity saveUser(SignUpEntity entity, String temporayPassword) {
		SignUpEntity signUpEntity = repo.save(entity);
		String email = signUpEntity.getEmail();
		String role = signUpEntity.getRole();
		emailSender.sendEmail(email, temporayPassword,role);
		return signUpEntity;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public SignUpEntity savePasswordUpdate(String status, String pwd, String email) {
		Integer res = repo.updateUserDetail(status, email, pwd);
		return null;
	}

	@Override
	public SignUpEntity getUserByEmail(String mail) {
		SignUpEntity userDetail = repo.getUserDetail(mail);
		return userDetail;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public SignUpEntity saveForgotPasswordUpdate(String pwd, String email) {
		Integer res = repo.forgotUpdateUserDetail(pwd, email);
		return null;
	}
	
	@Override
	public Integer findByEmail(String email) {
		Integer emailId = repo.searchByEmailId(email);
		return emailId;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Integer deactivateUser(String email,String val) {
		Integer deactivateUser = repo.deactivateUser(email,val);
		return deactivateUser;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Integer activateUser(String email, String val) {
		Integer activateUser = repo.activateUser(email, val);
		return activateUser;
	}

	@Override
	public ResponseEntity<Summary> getVechileDetails(@RequestParam("regNO")String regNo)throws HttpStatusCodeException {
		String RTO_REST_URL="http://localhost:9090/ownerRest?oid="+regNo;
	//	try {
			responseEntity = restTemplate.exchange(RTO_REST_URL, HttpMethod.GET,null, Summary.class,String.class);
		//int statusCodeValue = responseEntity.getStatusCodeValue();
		//Summary body = responseEntity.getBody();
		//}
		//catch(HttpStatusCodeException e) {
		//	int value = e.getStatusCode().value();
			
		//}
			return responseEntity;
	}

}
