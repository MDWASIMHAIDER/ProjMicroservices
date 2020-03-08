package com.tollplaza.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tollplaza.entity.SignUpEntity;

@Repository
public interface SignUpRepository extends JpaRepository<SignUpEntity,Serializable>{

}
