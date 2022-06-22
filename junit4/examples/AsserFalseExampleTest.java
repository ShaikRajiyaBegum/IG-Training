package com.hcl.junit4.examples;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class AsserFalseExampleTest {

	@Test
	public void testisEvenNumber() {
		assertFalse(TestingExample.isEvenNumber(1));
	}
}
