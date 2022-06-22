package com.hcl.java8.streamexamples;

import java.util.Arrays;
import java.util.List;

public class CountStringLengthMoreThan3 {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("gh", "abcd", "poi", "deflkij", "ghi", "def", "dfryu");
		// Counting the String Length MoreThan 3
		int count = (int) names.stream().filter(n -> n.length() > 3).count();
		System.out.println(count);
	}

}
