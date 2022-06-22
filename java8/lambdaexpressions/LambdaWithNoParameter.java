package com.hcl.java8.lambdaexpressions;

interface interf {
	public String say();
}

public class LambdaWithNoParameter {

	public static void main(String[] args) {

		interf s = () -> "I have nothing to say.";

		System.out.println(s.say());
	}

}
