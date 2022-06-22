package com.hcl.java8.methodreferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InstanceMethodReferenceExample {

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("Rajiya", "develop", 40000.0));
		empList.add(new Employee("Ramya", "accounts", 12000.0));
		empList.add(new Employee("Raghava", "marketing", 65000.0));

		MyComparator comp = new MyComparator();
		System.out.println("Sorted list with method reference...");
		Collections.sort(empList, comp::compare);
		empList.forEach(System.out::println);

		System.out.println("Sorted list with Lambda expressions...");
		Collections.sort(empList, ((emp1, emp2) -> emp1.getSalary().compareTo(emp2.getSalary())));
		empList.forEach(s -> System.out.println(s));

	}
}
