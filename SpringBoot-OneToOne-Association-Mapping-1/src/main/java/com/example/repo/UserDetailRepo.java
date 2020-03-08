package com.example.repo;

import java.io.Serializable;

import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.CriteriaUpdateImpl;
import org.springframework.data.repository.CrudRepository;

import com.example.user.UsersDetail;

public interface UserDetailRepo extends CrudRepository<UsersDetail, Serializable>{

	

}
