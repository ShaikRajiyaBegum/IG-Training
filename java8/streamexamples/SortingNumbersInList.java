package com.hcl.java8.streamexamples;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class SortingNumbersInList {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 17, 2, 9, 150, 4, 45, 11, 8, 6);

		// sorting the numbers in reverse order
		numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		// sorting the numbers in natural order
		numbers.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
	}

}
