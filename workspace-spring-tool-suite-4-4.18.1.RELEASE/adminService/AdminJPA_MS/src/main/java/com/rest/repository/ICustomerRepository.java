package com.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.model.Customer;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

}
