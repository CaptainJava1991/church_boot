package com.agnc.carthy.repository;

import com.agnc.carthy.model.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends CrudRepository<User, Long>{
	
	
    public User findByMail(String mail);

	public User findByUsername(String name);
}
