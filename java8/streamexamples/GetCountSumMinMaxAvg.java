package com.hcl.java8.streamexamples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;

public class GetCountSumMinMaxAvg {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(6, 2, 1, 1, 9, 150, 150, 4, 45, 4, 8, 6);
		IntSummaryStatistics numbers1 = numbers.stream().mapToInt(n -> n).summaryStatistics();
		System.out.println(numbers1);
	}

}
