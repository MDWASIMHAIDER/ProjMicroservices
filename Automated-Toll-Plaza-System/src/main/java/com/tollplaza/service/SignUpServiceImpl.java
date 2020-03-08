package com.tollplaza.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.tollplaza.entity.SignUpEntity;
import com.tollplaza.repository.SignUpRepository;

@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private SignUpRepository repo;

	Logger log = LoggerFactory.getLogger(SignUpService.class);

	void sendEmail(String email,String tempPassword) {

		SimpleMailMessage msg = new SimpleMailMessage();
		
		String html = "Temporary Password--" + tempPassword
				+ "\nClick Here To Update http://localhost:9090/updateController/updateurl";
		// messageBodyPart.setText(html, "UTF-8", "html");
		try {
			msg.setTo(email);
			// msg.setFrom("wasim.haider91@gmail.com");
			msg.setSubject("Testing from Spring Boot");
			msg.setText(html);

			javaMailSender.send(msg);
		} catch (MailException e) {
			log.info("exception in sending mail" + e.getMessage());
		}
	}

	@Override
	public SignUpEntity saveUser(SignUpEntity entity,String temporayPassword) {
		SignUpEntity signUpEntity = repo.save(entity);
		String email = signUpEntity.getEmail();
		sendEmail(email,temporayPassword);
		return signUpEntity;
	}

}
