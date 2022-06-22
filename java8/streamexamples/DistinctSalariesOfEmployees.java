package com.hcl.java8.streamexamples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DistinctSalariesOfEmployees {

	public static void main(String[] args) {

		// finding distinct salaries of employees
		List<Integer> employesalaries = Arrays.asList(16000, 12000, 12000, 20000, 19000, 16000, 15000, 45000);
		employesalaries.stream().distinct().forEach(System.out::println);

	}

}
