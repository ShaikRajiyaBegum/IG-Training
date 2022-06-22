package com.hcl.junit4.examples;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StudentExampleTest {

	StudentExample obj = new StudentExample();

	@Test
	public void testAdd() {
		obj.add("Rajiya");
		obj.add("samad");
		obj.add("sam");
		obj.add("geetha");
		assertEquals("Adding 4 student to list", 4, obj.sizeOfStudent());
	}

	@Test
	public void testSize() {
		obj.add("Rajiya");
		obj.add("sam");
		obj.add("geetha");
		obj.add("ram");
		assertEquals("Checking size of List", 4, obj.sizeOfStudent());
	}

	@Test
	public void testRemove() {
		obj.add("ram");
		obj.add("seetha");
		obj.add("mani");
		obj.remove("phani");
		assertEquals("Removing 1 student from list", 3, obj.sizeOfStudent());
	}

	@Test
	public void removeAll() {
		obj.removeAll();
	}
}
