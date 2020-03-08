package com.tollplaza.rtovechiledatarepository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tollplaza.rtovechiledata.VechileEntity;


public interface VechileRepository extends JpaRepository<VechileEntity, Serializable>{
	
	/*@Query("from VechileEntity e where e.detail.vechile_Owner_Id=:oid")
	public VechileEntity getVechileById(Integer oid);*/
}
