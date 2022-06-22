package com.hcl.junit4.examples;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SumLogicTest {

	@Test
	public void TestSumLogic() {
		assertEquals(5, SumLogic.sum(2, 3));

	}

}
