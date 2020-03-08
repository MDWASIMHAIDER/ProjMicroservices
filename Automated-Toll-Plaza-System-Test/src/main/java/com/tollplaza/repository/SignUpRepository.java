package com.tollplaza.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tollplaza.entity.SignUpEntity;

@Repository
public interface SignUpRepository extends JpaRepository<SignUpEntity,Serializable>{
	
	@Modifying
	@Query("update SignUpEntity u set u.status =:unlocked,u.pazzword=:pwd where u.email=:email1 ")
	public Integer updateUserDetail(@Param("unlocked")String unlocked,@Param("pwd")String pwd,@Param("email1")String email1); 

	@Modifying
	@Query("update SignUpEntity u set u.pazzword=:pwd where u.email=:email1 ")
	public Integer forgotUpdateUserDetail(@Param("pwd")String pwd,@Param("email1")String email1); 

	@Query("from SignUpEntity s where s.email=:mail ")
	public SignUpEntity getUserDetail(String mail);
	
	@Query("select count(1) from SignUpEntity where email=:mail")
	public Integer searchByEmailId(String mail);
	
	@Modifying
	@Query("update SignUpEntity u set u.active_switch=:val where u.email=:email1 ")
	public Integer deactivateUser(String email1,String val);
	
	@Modifying
	@Query("update SignUpEntity u set u.active_switch=:val where u.email=:email1 ")
	public Integer activateUser(String email1,String val);
}
