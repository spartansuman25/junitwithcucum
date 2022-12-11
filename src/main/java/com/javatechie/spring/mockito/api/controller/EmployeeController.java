package com.javatechie.spring.mockito.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.mockito.api.model.Employee;
import com.javatechie.spring.mockito.api.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@PostMapping(value = "/save")
	public Employee saveUser(@RequestBody Employee employee) {
		return service.addEmployee(employee);
	}

	@GetMapping("/getUsers")
	public List<Employee> findAllUsers() {
		return service.getEmployees();
	}

	@GetMapping("/getUserByAddress/{address}")
	public List<Employee> findUserByAddress(@PathVariable String address) {
		return service.getEmployeebyAddress(address);
	}

	@DeleteMapping(value="/remove")
	public Employee removeUser(@RequestBody Employee employee) {
		service.deleteEmployee(employee);
		return employee;
	}
}
