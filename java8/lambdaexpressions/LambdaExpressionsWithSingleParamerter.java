package com.hcl.java8.lambdaexpressions;

interface interf1 {
	public String say(String name);
}

public class LambdaExpressionsWithSingleParamerter {

	public static void main(String[] args) {

		interf1 s1 = name -> "Hello, " + name;

		System.out.println(s1.say("Rajiya"));

	}
}
