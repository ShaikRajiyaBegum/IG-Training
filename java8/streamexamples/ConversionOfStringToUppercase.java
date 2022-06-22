package com.hcl.java8.streamexamples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConversionOfStringToUppercase {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("abn", "abcd", "nb", "apoi", "os", "def", "wi", "fi", "ghi", "def", "ant");
		// Conversion Of String To Uppercase and joined by comma
		String names1 = names.stream().map(n -> n.toUpperCase()).collect(Collectors.joining(","));
		System.out.println(names1);
	}

}
