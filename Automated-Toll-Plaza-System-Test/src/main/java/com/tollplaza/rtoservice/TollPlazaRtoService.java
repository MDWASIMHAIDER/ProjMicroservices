package com.tollplaza.rtoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tollplaza.rtovechiledata.AddressEntity;
import com.tollplaza.rtovechiledata.OwnerEntity;
import com.tollplaza.rtovechiledata.RegistrationEntity;
import com.tollplaza.rtovechiledata.VechileEntity;
import com.tollplaza.rtovechiledatarepository.AddressRepository;
import com.tollplaza.rtovechiledatarepository.OwnerRepository;
import com.tollplaza.rtovechiledatarepository.RegistrationRepository;
import com.tollplaza.rtovechiledatarepository.VechileRepository;

@Service
public class TollPlazaRtoService {
	
	@Autowired
	private OwnerRepository ownerRepo;
	@Autowired
	private AddressRepository addressRepo;
	@Autowired
	private VechileRepository vechileRepo;
	@Autowired
	private RegistrationRepository registrationRepo;
	
	
	public OwnerEntity saveOwner(OwnerEntity entity) {
		OwnerEntity ownerEntity = ownerRepo.save(entity);
		return ownerEntity;
	}
	
	public AddressEntity saveAddress(AddressEntity entity) {
		AddressEntity addressEntity = addressRepo.save(entity);
		return addressEntity;
	}
	
	public VechileEntity saveVechile(VechileEntity entity) {
		VechileEntity vechileEntity = vechileRepo.save(entity);
		return vechileEntity;
	}
	public RegistrationEntity saveReg(RegistrationEntity entity) {
		RegistrationEntity registrationEntity = registrationRepo.save(entity);
		return registrationEntity;
	}
}
