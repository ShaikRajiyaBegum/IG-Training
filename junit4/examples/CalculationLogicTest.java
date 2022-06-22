package com.hcl.junit4.examples;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculationLogicTest {

	@Test
	public void testFindMax() {
		assertEquals(4, CalculationLogic.findMax(new int[] { 1, 3, 4, 2 }));
		assertEquals(-1, CalculationLogic.findMax(new int[] { -12, -1, -3, -4, -2 }));
	}

}
