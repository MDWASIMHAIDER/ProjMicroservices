package com.vechile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vechile.entity.OwnerEntity;

public interface VechileRepository extends JpaRepository<OwnerEntity, Integer>{

}
