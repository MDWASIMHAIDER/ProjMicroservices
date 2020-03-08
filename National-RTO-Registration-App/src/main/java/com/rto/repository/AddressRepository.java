package com.rto.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rto.entity.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Serializable> {
	
	//e is alias name of AddressEntity
	@Query("from AddressEntity e where e.detail.vechile_Owner_Id=:oid")
	public AddressEntity getAddressByOwnerId(Integer oid);
}
