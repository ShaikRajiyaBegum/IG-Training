package com.hcl.exceptionhandling;

import java.io.IOException;

class UserDefinedException extends Exception {
	public UserDefinedException(String str) {
		super(str);
	}
}

public class ThrowingUserDefinedExceptionExample {

	public static void main(String args[]) {
		try {
			// throw an object of user defined exception
			throw new UserDefinedException("This is user-defined exception");
		} catch (UserDefinedException ude) {
			System.out.println("Caught the exception");
			System.out.println(ude.getMessage());
		}
	}
}
