package com.hcl.junit4.examples;

public class TestingExample {

	public static boolean isEvenNumber(int number) {

		boolean result = false;
		if (number % 2 == 0) {
			result = true;
		}
		return result;
	}
}
