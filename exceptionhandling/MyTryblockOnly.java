package com.hcl.exceptionhandling;

import java.net.MalformedURLException;
import java.net.URL;

public class MyTryblockOnly {

	public static void main(String[] args) throws NullPointerException {
		try {
			String data = null;
			System.out.println(data.length());
			// URL url = new URL("http://www.google.com");
		} finally {

			System.out.println("hiiiii..rest of the code..");
		}

	}
}
