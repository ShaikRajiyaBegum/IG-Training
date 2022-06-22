package com.hcl.junit4.examples;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class ArrayObjectEqualsTest {

	Object[] expectedEmployees = new Object[3];

	@Before
	public void initInputs() {
		expectedEmployees[0] = new Employee(1, "rani", 43000);
		expectedEmployees[1] = new Employee(2, "raghu", 43000);
		expectedEmployees[2] = new Employee(3, "ramya", 43000);
	}

	@Test
	public void compareEmployees() {

		assertArrayEquals(expectedEmployees, Employee.getEmpList().toArray());
	}

}
