package com.hcl.java8.streamexamples;

import java.util.Arrays;
import java.util.List;

public class FindingSumOfList {

	public static void main(String[] args) {

		// finding the sum of numbers from list
		List<Integer> numbers = Arrays.asList(17, 2, 9, 150, 4, 45, 11, 8, 6);
		int sum = numbers.stream().mapToInt(n -> n).sum();
		System.out.println(sum);
	}

}
