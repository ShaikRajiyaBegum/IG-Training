package com.hcl.java8.streamexamples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeMain {

	public static void main(String[] args) {
		List<Employee> employee = new ArrayList<>();
		employee.add(new Employee(101, "Rajiya", 28, "female", "HR", 2022, 35000));
		employee.add(new Employee(102, "Rama", 25, "female", "manager", 2013, 45000));
		employee.add(new Employee(103, "sowjanya", 30, "female", "recruiter", 2022, 32000));
		employee.add(new Employee(104, "karim", 32, "male", "projectmanager", 2020, 31000));
		employee.add(new Employee(105, "gopi", 26, "male", "HR", 2022, 30000));
		employee.add(new Employee(106, "samad", 31, "male", "sales", 2011, 56000));
		employee.add(new Employee(107, "sai", 25, "male", "marketingteam", 2012, 62000));
		employee.add(new Employee(108, "prabhavathi", 35, "female", "marketingteam", 2016, 54000));
		employee.add(new Employee(109, "chinni", 27, "male", "sales", 2017, 25000));
		employee.add(new Employee(110, "krishna", 24, "male", "marketingteam", 2018, 76000));
		employee.add(new Employee(111, "hari", 25, "male", "productdevelopment", 2020, 46000));
		employee.add(new Employee(112, "harini", 23, "female", "productdevelopment", 2022, 53000));
		employee.add(new Employee(113, "sri", 20, "male", "productdevelopment", 2021, 48000));
		employee.add(new Employee(114, "lalitha", 22, "female", "productdevelopment", 2010, 64000));
		employee.add(new Employee(115, "keerthi", 29, "female", "sales and marketingteam", 2018, 98000));
		employee.add(new Employee(116, "Raj", 30, "male", "sales and marketingteam", 2019, 65000));

		// 1.How many male and female employees are there in the organization?
		Map<String, Long> countOfMaleAndFemale = employee.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("1.countOfMaleAndFemale:" + countOfMaleAndFemale);
		System.out.println("..................");

		// 2.Print the name of all departments in the organization?
		System.out.println("....2.Name of all departments in the organization.....");
		employee.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
		System.out.println("..................");

		// 3. What is the average age of male and female employees?
		Map<String, Double> averageAgeByGender = employee.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println("3.The average age of male and female employees:" + averageAgeByGender);
		System.out.println("..................");

		// 4.Get the details of highest paid employee in the organization?
		Optional<Employee> highestPaidEmployee = employee.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		// Employee highestPaidEmployee1 = highestPaidEmployee.get();
		System.out.println("highestPaidEmployee:" + highestPaidEmployee);
		System.out.println(highestPaidEmployee.get());
		System.out.println("..................");

		// 5.Get the names of all employees who have joined after 2015?
		System.out.println("names of all employees who have joined after 2015");
		employee.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);
		System.out.println("..................");

		// 6.Count the number of employees in each department?
		System.out.println("Count of the  employees in each department:");
		Map<String, Long> count = employee.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("count:" + count);
		System.out.println("..................");

		// 7.What is the average salary of each department?
		System.out.println(" Average salary of each department:");
		Map<String, Double> averageSalary = employee.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(averageSalary);
		System.out.println("..................");

		// 8.Get the details of youngest male employee in the product development
		// department?
		System.out.println("Details of youngest male employee in the product development department:");
		Optional<Employee> youngestMaleEmployee = employee.stream()
				.filter(e -> e.getDepartment() == "productdevelopment" && e.getGender() == "male")
				.min(Comparator.comparingInt(Employee::getAge));
		Employee youngestMaleEmployeeInProductDevelopment = youngestMaleEmployee.get();
		System.out.println(youngestMaleEmployeeInProductDevelopment);
		System.out.println("..................");

		// 9.Who has the most working experience in the organization?
		System.out.println("the most working experience in the organization:");
		Optional<Employee> workExperiencePerson = employee.stream()
				.min(Comparator.comparingInt(Employee::getYearOfJoining));
		System.out.println(workExperiencePerson.get());
		System.out.println("..................");

		// 10.How many male and female employees are there in the sales and marketing
		// team?
		System.out.println("male and female employees sales and marketing team:");
		Map<String, Long> countOfMalesAndFemales = employee.stream()
				.filter(e -> e.getDepartment() == "sales and marketingteam")
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(countOfMalesAndFemales);
		System.out.println("..................");

		// 11.What is the average salary of male and female employees?
		System.out.println("average salary of male and female employees:");
		Map<String, Double> averagesalaryOfmaleAndFemale = employee.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(averagesalaryOfmaleAndFemale);
		System.out.println("..................");

		// 12.List down the names of all employees in each department?
		System.out.println("names of all employees in each department:");
		Map<String, String> employeesInEachDepartment = employee.stream()
				.collect(Collectors.toMap(Employee::getName, Employee::getDepartment));
		System.out.println(employeesInEachDepartment);
		System.out.println("..................");

		// 13 What is the average salary and total salary of the whole organization?
		System.out.println("average salary and total salary of the whole organization:");
		Double averageSalary1 = employee.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		Double totalSalary1 = employee.stream().collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println("AverageSalary:" + averageSalary1);
		System.out.println("TotalSalary:" + totalSalary1);
		System.out.println("..................");
		System.out.println("....Another Approach to get avg salary and total salary..............");
		DoubleSummaryStatistics employeeSalaryStatistics = employee.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));

		System.out.println("Average Salary = " + employeeSalaryStatistics.getAverage());
		System.out.println("Total Salary = " + employeeSalaryStatistics.getSum());
		System.out.println("..................");

		// 14 Separate the employees who are younger or equal to 25 years from those
		// employees who are older than 25 years?
		System.out.println("Employees who are younger or equal to 25 years:");
		Map<String, Integer> youngEmployees = employee.stream().filter(e -> e.getAge() <= 25)
				.collect(Collectors.toMap(Employee::getName, Employee::getAge));
		System.out.println(youngEmployees);
		System.out.println("..................");
		System.out.println(".......Another approach...........");

		Map<Boolean, List<Employee>> partitionEmployeesByAge = employee.stream()
				.collect(Collectors.partitioningBy(e -> e.getAge() <= 25));
		Set<Entry<Boolean, List<Employee>>> entrySet = partitionEmployeesByAge.entrySet();

		for (Entry<Boolean, List<Employee>> entry : entrySet) {
			System.out.println("----------------------------");

			if (entry.getKey()) {
				System.out.println("Employees older than 25 years :");
			} else {
				System.out.println("Employees younger than or equal to 25 years :");
			}

			System.out.println("----------------------------");

			List<Employee> list = entry.getValue();

			for (Employee e : list) {
				System.out.println(e.getName());
			}
		}

		System.out.println("----------------------------");

		// 15 Who is the oldest employee in the organization? What is his age and which
		// department he belongs to?
		System.out.println("oldest employee in the organization:");
		Optional<Employee> oldestEmployee = employee.stream().max(Comparator.comparing(Employee::getAge));
		System.out.println(oldestEmployee.get());

	}
}
