package com.hcl.java8.lambdaexpressions;

public class LambdaExpressionToRunThread {

	public static void main(String[] args) {

		Runnable r = () -> {
			for (int i = 0; i <= 5; i++) {
				System.out.println("child Thread");
			}
		};
		Thread t = new Thread(r);
		t.start();
		for (int i = 6; i <= 10; i++) {
			System.out.println("main Thread");
		}

	}

}
