package com.batches.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.batches.entity.TagMasterEntity;

@Repository//it is optional when we are using predefine repository like jpa ,curd
public interface TagMasterRepository extends JpaRepository<TagMasterEntity,Serializable>{
	
	@Query("select USER_ID from TagMasterEntity  where TAG_ID =:tagId")
	public Integer findById(Integer tagId);
	
	//here no need to write query because we are folllwing findbySequence
}
