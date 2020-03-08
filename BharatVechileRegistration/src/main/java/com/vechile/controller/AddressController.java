package com.vechile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.vechile.repository.VechileOwnerAddressRepository;

@Controller("/address")
public class AddressController {
	@Autowired
	private VechileOwnerAddressRepository repo;
}
