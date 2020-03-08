package com.vechile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.vechile.repository.VechileRepository;

@Controller("/owner")
public class OwnerController {
	
	@Autowired
	private VechileRepository repo2;
}
