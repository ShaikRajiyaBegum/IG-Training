package com.hcl.java8.methodreferences;

interface Sayable {
	void say();
}

public class ReferenceToStaticMethod {

	public static void saySomething() {
		System.out.println("Hello, this is static method.");
	}

	public static void main(String[] args) {
		// Referring static method
		Sayable sayable = ReferenceToStaticMethod::saySomething;
		// Calling interface method
		sayable.say();

	}
}
