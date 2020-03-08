package com.tollplaza.rtovechiledatarepository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tollplaza.rtovechiledata.RegistrationEntity;


@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationEntity, Serializable> {
		
	}
