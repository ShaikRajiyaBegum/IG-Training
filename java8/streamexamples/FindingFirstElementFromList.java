package com.hcl.java8.streamexamples;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindingFirstElementFromList {

	public static void main(String[] args) {

		// finding the first number from list
		List<Integer> numbers = Arrays.asList(1,17, 2, 9, 150, 4, 45, 11, 8, 6);
		Optional<Integer> number = numbers.stream().findFirst();
		System.out.println(number.get());
	}

}
