package com.hcl.java8.streamexamples;

import java.util.Arrays;
import java.util.List;

public class StartingWith1FromList {

	public static void main(String[] args) {

		// finding the number which starts with 1
		List<Integer> numbers = Arrays.asList(17, 2, 9, 150, 4, 45, 11, 8, 6);
		numbers.stream().map(n -> n + "").filter(n -> n.startsWith("1")).forEach(System.out::println);
	}

}
