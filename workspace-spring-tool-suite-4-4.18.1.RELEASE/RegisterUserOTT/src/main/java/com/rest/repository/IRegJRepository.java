package com.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rest.model.RegisterUser;
@Repository
public interface IRegJRepository extends JpaRepository<RegisterUser, String> {
	RegisterUser validateUser(String email,String password);
}
