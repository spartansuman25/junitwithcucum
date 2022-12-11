package com.javatechie.spring.mockito.api.dao;

import java.util.List;


import com.javatechie.spring.mockito.api.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, Integer> {
	
	List<Employee> findByAddress(String address);

}
