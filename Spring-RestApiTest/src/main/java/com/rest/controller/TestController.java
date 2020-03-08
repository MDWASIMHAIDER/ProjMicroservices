package com.rest.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entity.RestEntity;
import com.rest.repository.RestTestRepository;

@RestController
public class TestController {
	
	@Autowired
	RestTestRepository repo;
	
	@GetMapping(value="/msg",produces="application/json")
	public @ResponseBody String showMsg(@PathParam("name")String name,@PathParam("desg")String desg) {
		RestEntity entity=new RestEntity();
		entity.setName(name);
		entity.setDesg(desg);
		repo.save(entity);
		return "gud night "+name;
	}

}
