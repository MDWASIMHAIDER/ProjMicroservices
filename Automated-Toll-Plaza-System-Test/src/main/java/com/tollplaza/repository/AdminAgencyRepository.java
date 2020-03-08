package com.tollplaza.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tollplaza.entity.AdminAgencyEntity;
import com.tollplaza.entity.SignUpEntity;

@Repository
public interface AdminAgencyRepository extends JpaRepository<AdminAgencyEntity, Serializable> {

	@Query("select count(1) from AdminAgencyEntity where email=:mail")
	public Integer searchAdminAgencyByEmailId(String mail);
	
	
	@Query("from AdminAgencyEntity s where s.email=:mail ")
	public AdminAgencyEntity getAgencyDetailByEmail(String mail);
	
	@Modifying
	@Query("update AdminAgencyEntity u set u.status =:unlocked,u.pazzword=:pwd where u.email=:email1 ")
	public Integer updateUserDetail(@Param("unlocked")String unlocked,@Param("pwd")String pwd,@Param("email1")String email1);
	
	@Modifying
	@Query("update AdminAgencyEntity u set u.active_Switch=:val where u.email=:email1 ")
	public Integer deactivateAgency(String email1,String val);
	
	@Modifying
	@Query("update AdminAgencyEntity u set u.active_Switch=:val where u.email=:email1 ")
	public Integer activateAgency(String email1,String val);
}
