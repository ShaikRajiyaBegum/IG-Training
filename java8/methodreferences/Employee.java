package com.hcl.java8.methodreferences;

public class Employee {

	private String name;
	private String account;
	private Double salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Employee(String name, String account, Double salary) {
		super();
		this.name = name;
		this.account = account;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", account=" + account + ", salary=" + salary + "]";
	}

}
