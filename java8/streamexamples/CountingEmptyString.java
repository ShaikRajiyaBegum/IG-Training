package com.hcl.java8.streamexamples;

import java.util.Arrays;
import java.util.List;

public class CountingEmptyString {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("","abcd", "", "def", "ghi", "def", "");
		//Counting the Empty String
		int count = (int) names.stream().filter(n -> n.isEmpty()).count();
		System.out.println(count);
	}

}
