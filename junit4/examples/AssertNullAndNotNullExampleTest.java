package com.hcl.junit4.examples;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class AssertNullAndNotNullExampleTest {

	TestingExample2 te2 = new TestingExample2();

	@Test
	public void testStudents() {
		assertNull(te2.students("key8"));
		assertNotNull(te2.students("key1"));
	}
}
