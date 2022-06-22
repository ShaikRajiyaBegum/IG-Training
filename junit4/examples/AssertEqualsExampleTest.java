package com.hcl.junit4.examples;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AssertEqualsExampleTest {

	@Test
	public void testMySimpleEqualsTest() {
		String str = "Rajiya";
		assertEquals(str, Employee.getEmpNameWithHighestSalary());

	}

	@Test
	public void testObjectEqualsTest() {
		Employee employee = new Employee(1, "rajiya", 75000);
		assertEquals(employee, Employee.getHighestPaidEmployee());

	}

}
