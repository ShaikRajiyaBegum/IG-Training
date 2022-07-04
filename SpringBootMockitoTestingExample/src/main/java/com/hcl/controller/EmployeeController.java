package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.Employee;

import com.hcl.repository.EmployeeRepository;

@RestController
@RequestMapping(value = "/Employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	// Add Employee
	@PostMapping("/addEmployee")
	public void addEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);

	}

	// Get All Employees
	@GetMapping("/get All Employees")
	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;

	}

}
