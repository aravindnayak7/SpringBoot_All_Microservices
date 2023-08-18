package com.rest.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.rest.model.Employee;
@Repository
//here i'm going to use query interface which will take the data from database
//employee class and u is the employee object
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// this is incase of sql @Query(value="select u from Employee u where u.empname = ?1 and u.password = ?2")
	//for mongo the query structure will be like this
//	@Query("{'empname':{$in : [?0]},'password': {$in : [?1]}}")
	@Query("select u from Employee u where u.empname = ?1 and u.password = ?2")
	public Employee validateUser(String empname,String password);
}
//crud
//jpa crud