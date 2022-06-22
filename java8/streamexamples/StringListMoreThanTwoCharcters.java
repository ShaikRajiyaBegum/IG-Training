package com.hcl.java8.streamexamples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringListMoreThanTwoCharcters {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("abn", "abcd", "nb", "apoi", "os", "def", "wi", "fi", "ghi", "def", "ant");
		// creation of String List MoreThan Two Charcters
		List<String> names1 = names.stream().filter(n -> n.length() > 2).collect(Collectors.toList());
		System.out.println(names1);
	}

}
