package com.hcl.exceptionhandling;

import java.io.IOException;

public class ThrowExample2 {

	public static void validate(int age) throws IOException {

		if (age < 18) {
			// throw Arithmetic exception if not eligible to vote
			throw new IOException("Person is not eligible to vote");
			//System.out.println("Person is not eligible to vote!!");
		} else {
			System.out.println("Person is eligible to vote!!");
		}
	}

	// main method
	public static void main(String args[]) {
		// calling the function
		try {
			validate(19);
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		} finally {
		}
		System.out.println("rest of the code...");
	}
}
