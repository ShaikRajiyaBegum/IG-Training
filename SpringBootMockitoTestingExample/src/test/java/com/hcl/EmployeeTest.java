package com.hcl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.controller.EmployeeController;
import com.hcl.model.Employee;

import com.hcl.repository.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
//@ExtendWith(MockitoExtension.class)
public class EmployeeTest {

	@InjectMocks
	EmployeeController employeeController;

	@Mock
	EmployeeRepository employeeRepository;

	// Save Employee
	@Test
	public void testAddEmployee() {

		Employee employee = new Employee(1, "rajiya", "ECE");
		employeeController.addEmployee(employee);
		assertNotNull(employee);
		verify(employeeRepository, times(1)).save(employee);
	}

	// getAll Employees
	@Test
	public void testGetAllEmployees() {
		List<Employee> empList = new ArrayList<>();

		empList.add(new Employee(1, "rajiya", "ECE"));
		empList.add(new Employee(2, "rajiya", "ECE"));
		empList.add(new Employee(3, "rajiya", "ECE"));

		when(employeeController.getAllEmployees()).thenReturn(empList);
		List<Employee> empList1 = (List<Employee>) employeeController.getAllEmployees();
		assertThat(empList1).isNotNull();
		assertThat(empList1.size()).isEqualTo(3);

	}

}
