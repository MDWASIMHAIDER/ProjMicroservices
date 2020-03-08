package com.tollplaza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tollplaza.entity.UpdateEntity;
import com.tollplaza.repository.UpdateRepository;

@Service
public class UpdateServiceImpl implements UpdateService {
	
	@Autowired
	private UpdateRepository repo;
	
	@Override
	public UpdateEntity savePasswordUpdate(UpdateEntity entity) {
		UpdateEntity updateEntity = repo.save(entity);
		return updateEntity;
	}

}
