package com.hcl.java8.streamexamples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SquareOAllDistinctNumbers {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(6, 2, 14, 16, 4, 45, 4, 8, 6);
		List<Integer> numbers1 = numbers.stream().map(n -> n * n).distinct().collect(Collectors.toList());
		System.out.println(numbers1);
	}

}
