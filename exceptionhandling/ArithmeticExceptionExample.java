package com.hcl.exceptionhandling;

public class ArithmeticExceptionExample {

	public static void main(String[] args) {
		int i = 100;
		int j = 0;
		int data;

		// usage of try-catch to handle the exceptions
		try {

			data = i / j;
			System.out.println(data);
		} catch (ArithmeticException e) {
			System.out.println(e);
			// e.printStackTrace();
			System.out.println("cannit divided by zero");
		}
		// rest code of the program
		System.out.println("rest...");
		System.out.println("...............");

		// catch is used to solve the exceptions

		try {

			data = i / j;
		} catch (ArithmeticException e) {

			data = i / (j + 2);
			System.out.println(data);
		}
		// rest code of the program
		System.out.println("rest of the code...");
	}

}
