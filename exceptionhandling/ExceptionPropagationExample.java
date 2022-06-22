package com.hcl.exceptionhandling;

public class ExceptionPropagationExample {

	void m() {
		int data = 50 / 0; // here exception is not handled by m() so it is propagated to previous method
	}

	void n() {
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
		ExceptionPropagationExample obj = new ExceptionPropagationExample();
		obj.p();
		System.out.println("normal flow...");
	}
}
