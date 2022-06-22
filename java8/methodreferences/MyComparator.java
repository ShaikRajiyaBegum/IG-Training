package com.hcl.java8.methodreferences;

public class MyComparator {
	public int compare(Employee emp1, Employee emp2) {

		return (emp1.getSalary()).compareTo(emp2.getSalary());

	}

}
