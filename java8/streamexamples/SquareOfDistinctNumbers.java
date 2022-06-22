package com.hcl.java8.streamexamples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SquareOfDistinctNumbers {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(6, 2, 1, 1, 9, 150, 150, 4, 45, 4, 8, 6);
		Set<Integer> duplicate = new HashSet<>();
		//Finding the dulplicate numbers from list
		numbers.stream().filter(n -> !duplicate.add(n)).forEach(System.out::println);

	}

}
