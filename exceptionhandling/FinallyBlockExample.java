package com.hcl.exceptionhandling;

public class FinallyBlockExample {

	public static void main(String[] args) {
		try {
			int data = 25 / 5;
			System.out.println("data:" +data);
			System.out.println("...Another code");
			int i = 10 / 0;
			System.out.println(i);
		}
		// catch won't be executed
		catch (NullPointerException e) {
			System.out.println(e);
		}
		// executed regardless of exception occurred or not
		finally {
			System.out.println("finally block is always executed");
		}

		System.out.println("rest of the code...");
	}

}
