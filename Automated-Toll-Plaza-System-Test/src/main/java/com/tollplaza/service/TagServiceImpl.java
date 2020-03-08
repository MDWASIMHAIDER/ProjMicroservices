package com.tollplaza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tollplaza.entity.TagMasterEntity;
import com.tollplaza.repository.TagRepository;

@Service
public class TagServiceImpl implements TagService{
	
	@Autowired
	private TagRepository repo;
	
	@Override
	public TagMasterEntity saveTagsDetails(TagMasterEntity entity) {
		TagMasterEntity tagMasterEntity = repo.save(entity);
		return tagMasterEntity;
	}

	@Override
	public Integer findTagByVechileRegNo(String regNo) {
		Integer findTagByRegNo = repo.findTagByRegNo(regNo);
		return findTagByRegNo;
	}
	
	

}
