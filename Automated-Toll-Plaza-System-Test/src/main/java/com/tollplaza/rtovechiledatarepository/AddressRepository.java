package com.tollplaza.rtovechiledatarepository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tollplaza.rtovechiledata.AddressEntity;


@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Serializable> {
	
	/*@Query("from AddressEntity e where e.detail.vechile_Owner_Id=:oid")
	public AddressEntity getAddressByOwnerId(Integer oid);*/
}
