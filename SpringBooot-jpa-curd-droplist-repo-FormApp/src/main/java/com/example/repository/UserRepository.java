package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer>{
	//no need to provide implementation
	@Query("select email from UserEntity")
	public List<String>findallEmails();
	
	
	//custom hql query
	//it will map positional parameter with fun parameter
	@Query("select email from UserEntity where serialNumber=:uid")
	public String findEmailById(Integer uid);
	
	@Transactional
	@Modifying
	@Query("update UserEntity set status='inactive' where serial_number=:uid ")
	public void deactivateAccount(Integer uid);
	
	
	
	//@Query(value="select serialNumber,uname,pazzword,email,phone,countries,status from UserEntity where status=?st",nativeQuery=true)
	//List<UserEntity> findAllUser(Pageable page);
	
	@Query(value="select serial_Number,uname,pazzword,email,phone,countries,status from userregistration where status='active'",
			countQuery="select count(*) from userregistration where status='active'",
			nativeQuery=true)
	Page<UserEntity> findAllUser(Pageable page);
}
