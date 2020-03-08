package com.example.repo;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.user.Users;

@Repository
public interface UsersRepo extends CrudRepository<Users, Serializable>{

}
