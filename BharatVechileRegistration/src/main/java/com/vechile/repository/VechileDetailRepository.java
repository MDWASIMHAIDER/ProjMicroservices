package com.vechile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vechile.entity.VechileEntity;

public interface VechileDetailRepository extends JpaRepository<VechileEntity, Integer>{

}
