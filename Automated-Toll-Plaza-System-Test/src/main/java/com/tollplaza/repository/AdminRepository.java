package com.tollplaza.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tollplaza.entity.AdminLoginEntity;

@Repository
public interface AdminRepository extends JpaRepository<AdminLoginEntity, Serializable>{
	
	@Query("select count(1) from AdminLoginEntity where adminId=:userId and adminPassword=:pazzword")
	public Integer authenticateAdminDetails(String userId,String pazzword);
}
