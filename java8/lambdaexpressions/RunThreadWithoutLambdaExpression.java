package com.hcl.java8.lambdaexpressions;

class MyRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println("child Thread");
		}

	}
}

public class RunThreadWithoutLambdaExpression {
	public static void main(String[] args) {

		Runnable r = new MyRunnable();
		Thread t = new Thread(r);
		t.start();
		for (int i = 6; i <= 10; i++) {
			System.out.println("main Thread");
		}

	}

}
