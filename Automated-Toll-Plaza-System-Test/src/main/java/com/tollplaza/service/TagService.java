package com.tollplaza.service;

import com.tollplaza.entity.TagMasterEntity;

public interface TagService {
	public TagMasterEntity saveTagsDetails(TagMasterEntity entity);
	public Integer findTagByVechileRegNo(String regNo);
}
