package com.hcl.junit4.examples;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AsserTrueExampleTest {

	@Test
	public void testisEvenNumber() {
		assertTrue(TestingExample.isEvenNumber(4));
	}
}
