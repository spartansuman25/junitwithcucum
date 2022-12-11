package com.javatechie.spring.mockito.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.spring.mockito.api.dao.EmployeeRepository;
import com.javatechie.spring.mockito.api.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	

	public Employee addEmployee(Employee employee) {
		return repository.save(employee);
	}

	public List<Employee> getEmployees() {
		List<Employee> employees = repository.findAll();
		System.out.println("Getting data from DB : " + employees);
		return employees;
	}

	public List<Employee> getEmployeebyAddress(String address) {
		return repository.findByAddress(address);
	}

	public void deleteEmployee(Employee employee) {
		repository.delete(employee);
	}
}
