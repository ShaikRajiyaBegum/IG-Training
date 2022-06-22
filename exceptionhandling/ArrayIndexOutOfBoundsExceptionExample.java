package com.hcl.exceptionhandling;

public class ArrayIndexOutOfBoundsExceptionExample{

	public static void main(String[] args) {

		int a[] = new int[5];
		try {
			a[10] = 50; // ArrayIndexOutOfBoundsException

			System.out.println(a[10]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
		System.out.println("rest");

	}

}
