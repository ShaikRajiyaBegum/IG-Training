package com.hcl.java8.streamexamples;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class FindingMaxElementFromList {

	public static void main(String[] args) {

		// finding maximum number from list
		List<Integer> numbers = Arrays.asList(1, 17, 2, 9, 150, 4, 45, 11, 8, 6);
		OptionalInt number = numbers.stream().mapToInt(n -> n).max();
		System.out.println(number);
	}

}
