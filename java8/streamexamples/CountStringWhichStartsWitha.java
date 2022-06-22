package com.hcl.java8.streamexamples;

import java.util.Arrays;
import java.util.List;

public class CountStringWhichStartsWitha {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("abn", "abcd", "apoi", "def", "ghi", "def", "ant");
		// Count the String Which Starts With "a"
		int count = (int) names.stream().filter(n -> n.startsWith("a")).count();
		System.out.println(count);
	}

}
