package com.hcl.exceptionhandling;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileNotFoundExceptionExample {

	public static void main(String[] args) {

		try {
			PrintWriter pw = new PrintWriter("jtp.txt"); // may throw exception
			pw.println("saved");
		} catch (FileNotFoundException e) {

			System.out.println(e);
		}
		System.out.println("File saved successfully");
	}

}
