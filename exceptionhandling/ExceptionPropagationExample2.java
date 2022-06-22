package com.hcl.exceptionhandling;

import java.io.IOException;

public class ExceptionPropagationExample2 {

	void m() throws IOException {
		throw new java.io.IOException("device error");// IO is checked exception .here checked exception is not
														// propagated.so need to handle by throws 
	}

	void n() throws IOException {
		m();// propagated to previous method
	}

	void p() {
		try {
			n();
		} catch (Exception e) {
			System.out.println("exception handled");
		}
	}

	public static void main(String args[]) {
		ExceptionPropagationExample2 obj = new ExceptionPropagationExample2();
		obj.p();
		System.out.println("normal flow...");
	}
}
