package com.tollplaza.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tollplaza.entity.UpdateEntity;

@Repository
public interface UpdateRepository extends JpaRepository<UpdateEntity, Serializable>{

}
