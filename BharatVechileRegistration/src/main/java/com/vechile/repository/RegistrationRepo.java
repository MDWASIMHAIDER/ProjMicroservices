package com.vechile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vechile.entity.RegistrationEntity;

public interface RegistrationRepo extends JpaRepository<RegistrationEntity, Integer>{

}
