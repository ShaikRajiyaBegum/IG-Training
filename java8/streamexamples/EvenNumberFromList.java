package com.hcl.java8.streamexamples;

import java.util.Arrays;
import java.util.List;

public class EvenNumberFromList {

	public static void main(String[] args) {

		// Finding even numbers from list
		List<Integer> numbers = Arrays.asList(7, 2, 9, 68, 4, 45, 44, 8, 6);
		numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

	}

}
