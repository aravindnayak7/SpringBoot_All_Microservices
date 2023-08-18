package com.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rest.model.Customer;
@Repository
public interface ICustomerRepository extends MongoRepository<Customer, String> {

}
