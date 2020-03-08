package com.tollplaza.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tollplaza.entity.TagMasterEntity;

public interface TagRepository extends JpaRepository<TagMasterEntity, Serializable>{
	
	@Query("select count(*) from TagMasterEntity where vechileRegNumber=:regNo")
	public Integer findTagByRegNo(String regNo);
}
