package com.example.rest;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.UserEntity;
import com.example.repository.UserRepository;
import com.example.user.User;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class UserRestController {
	
	@Autowired
	UserRepository repo;
	
	@GetMapping(value="/getuser",produces= {"application/json","application/xml"})
	public User showUser(@RequestParam("uid")Integer uid) {
		Optional<UserEntity> users = repo.findById(uid);
		UserEntity userEntity = users.get();
		User user=new User();
		BeanUtils.copyProperties(userEntity, user);
		return user;
		
	}

}
