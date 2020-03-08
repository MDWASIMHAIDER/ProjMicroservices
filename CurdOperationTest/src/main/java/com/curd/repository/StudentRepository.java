package com.curd.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.curd.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Serializable>{
	
	
	@Transactional
	@Modifying
	@Query("delete from StudentEntity where id=:id")
	public int deleteStudentById(int id);
	
	/*@Query("update from StudentEntity set")
	public int updateStudentById(int id);*/
}
