package com.tollplaza.rtovechiledatarepository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sun.xml.bind.v2.model.core.ID;
import com.tollplaza.rtovechiledata.OwnerEntity;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerEntity, Serializable> {
	
}
