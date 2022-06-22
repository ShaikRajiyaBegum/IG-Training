package com.hcl.java8.streamexamples;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemovalOfEmptyString {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("", "abcd", "", "def", "ghi", "def", "");
		// Removal Of EmptyString
		List<String> names1 = names.stream().filter(n -> !n.isEmpty()).collect(Collectors.toList());
		System.out.println(names1);
	}

}
