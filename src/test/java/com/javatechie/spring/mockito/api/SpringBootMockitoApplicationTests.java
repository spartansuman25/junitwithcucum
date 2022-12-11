package com.javatechie.spring.mockito.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.javatechie.spring.mockito.api.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.javatechie.spring.mockito.api.dao.EmployeeRepository;
import com.javatechie.spring.mockito.api.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMockitoApplicationTests {

	@Autowired
	private EmployeeService service;

	@MockBean
	private EmployeeRepository repository;

	@Test
	public void getEmployeesTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Employee(376, "Thapa Suman", 31, "Nepal"), new Employee(958, "Demo", 35, "Nepal")).collect(Collectors.toList()));
		assertEquals(2, service.getEmployees().size());
	}

	@Test
	public void getEmployeebyAddressTest() {
		String address = "Kathmandu";
		when(repository.findByAddress(address))
				.thenReturn(Stream.of(new Employee(376, "Anil", 31, "Nepal")).collect(Collectors.toList()));
		assertEquals(1, service.getEmployeebyAddress(address).size());
	}

	@Test
	public void saveEmployeeTest() {
		Employee employee = new Employee(999, "Ram", 33, "India");
		when(repository.save(employee)).thenReturn(employee);
		assertEquals(employee, service.addEmployee(employee));
	}

	@Test
	public void deleteEmployeeTest() {
		Employee employee = new Employee(999, "Pradeep", 33, "Nepal");
		service.deleteEmployee(employee);
		verify(repository, times(1)).delete(employee);
	}

}
