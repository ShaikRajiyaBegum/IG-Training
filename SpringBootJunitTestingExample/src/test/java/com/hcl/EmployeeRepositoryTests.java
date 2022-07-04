package com.hcl;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.hcl.model.Employee;
import com.hcl.repository.EmployeeRepository;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepositoryTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	// Junit test for save employee
	@Test
	@Order(1)
	@Rollback(value = false)
	public void testSaveEmployee() {
		//Employee emp = Employee.builder().firstName("").lastName("").email("").build();
		Employee employee = new Employee("Rajiya", "Shaik", "ShaikRajiya@gmail.com");
		employeeRepository.save(employee);
		Assertions.assertThat(employee.getId()).isGreaterThan(0);

	}

	// Junit test for get employee
	@Test
	@Order(2)
	@Rollback(value = false)
	public void testgetEmployee() {

		Employee employee = employeeRepository.findById(1L).get();

		Assertions.assertThat(employee.getId()).isEqualTo(1L);

	}

	// Junit test for get All employee
	@Test
	@Order(3)
	@Rollback(value = false)
	public void testgetAllEmployees() {

		List<Employee> employees = employeeRepository.findAll();

		Assertions.assertThat(employees.size()).isGreaterThan(0);

	}

	// Junit test for update employee
	@Test
	@Order(4)
	@Rollback(value = false)
	public void testUpdateEmployee() {

		Employee employee = employeeRepository.findById(1L).get();
		employee.setEmail("raj@gmail.com");
		Employee employeeUpdated = employeeRepository.save(employee);
		Assertions.assertThat(employeeUpdated.getEmail()).isEqualTo("raj@gmail.com");

	}

	// Junit test for delete employee
	@Test
	@Order(5)
	@Rollback(value = false)
	public void testDeleteEmployee() {

		Employee employee = employeeRepository.findById(1L).get();
		employeeRepository.delete(employee);

		Optional<Employee> optionalemployee = employeeRepository.findByemail("raj@gmail.com");

		Employee employee1 = null;
		if (optionalemployee.isPresent()) {
			employee1 = optionalemployee.get();
		}
		Assertions.assertThat(employee1).isNull();

	}

}
