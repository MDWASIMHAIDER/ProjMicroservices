package com.rest.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rest.entity.RestEntity;

@Repository
public interface RestTestRepository extends JpaRepository<RestEntity, Serializable>{
	
}
