package com.vechile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vechile.entity.AddressEntity;

public interface VechileOwnerAddressRepository extends JpaRepository<AddressEntity, Integer> {

}
