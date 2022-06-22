package com.hcl.exceptionhandling;

public class NestedTryBlockExample {

	public static void main(String args[]) {

		try {
			// inner try block 1
			try {
				System.out.println("going to divide by 0");
				int b = 39 / 0;
			} catch (ArithmeticException e) {
				System.out.println(e);
			}

			// inner try block 2
			try {
				int a[] = new int[5];
				a[5] = 4;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e);
			}

			System.out.println("other statement");
			
		} catch (Exception e) {
			System.out.println("handled the exception (outer catch)");
		}

		System.out.println("normal flow..");
	}
}
