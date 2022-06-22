package com.hcl.junit4.examples;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class AssertNotSameAndAssertSameExampleTest {
	TestingExample2 te2 = new TestingExample2();

	@Test
	public void testStudents() {

		assertNotSame(te2.students("key1"), te2.students("key2"));
		assertSame(te2.students("key1"), te2.students("key1"));
	}

}
