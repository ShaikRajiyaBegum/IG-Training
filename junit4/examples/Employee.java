package com.hcl.junit4.examples;

import java.util.ArrayList;
import java.util.List;

public class Employee {

	private String name;
	private int empId;
	private double salary;

	public Employee(int id, String name, int sal) {
		this.empId = id;
		this.name = name;
		this.salary = sal;

	}

	public boolean equals(Object obj) {
		Employee emp = (Employee) obj;
		boolean status = false;
		if (this.name.equalsIgnoreCase(emp.name) && this.empId == emp.empId && this.salary == emp.salary) {
			status = true;
		}
		return status;

	}

	public static List<Employee> getEmpList() {
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee(1, "rani", 43000));
		emps.add(new Employee(2, "raghu", 43000));
		emps.add(new Employee(3, "ramya", 43000));

		return emps;

	}

	public static String getEmpNameWithHighestSalary() {
		// .....logic.....
		return "Rajiya";
	}

	public static Employee getHighestPaidEmployee() {
		// .....logic.....
		return new Employee(1, "Rajiya", 75000);

	}

	public int hashcode() {
		return this.empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
