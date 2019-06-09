package com.rvlstudio.nayla.transferrable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import com.rvlstudio.nayla.service.transferrable.Result;
import com.rvlstudio.nayla.service.transferrable.ResultTO;

import org.junit.Test;

/**
 * ResultTOTest
 */
public class ResultTOTest {
	@Test
	public void testConstructor() {
		ResultTO<String> to = new ResultTO<String>("Success"){};
		assertTrue(to.isSuccessFul());
		assertTrue(to.getPayload().isPresent());
	}

	@Test
	public void testCopyConstructor() {
		ResultTO<String> to = new ResultTO<String>(Result.RegistratieMislukt){};
		ResultTO<String> to2 = new ResultTO<String>(to) {};
		assertEquals(to.getResult(), to2.getResult());
	}

	@Test
	public void testResultConstructor() {
		ResultTO<String> to = new ResultTO<String>(Result.RegistratieMislukt){};
		assertFalse(to.isSuccessFul());
	}

	@Test
	public void testEqual() {
		ResultTO<String> to1 = new ResultTO<String>("Success"){};
		ResultTO<String> to2 = to1;
		assertEquals(to1, to2);
	}

	@Test
	public void testNotEqual() {
		ResultTO<String> to1 = new ResultTO<String>("Success"){};
		ResultTO<String> to2 = null;
		assertNotEquals(to1, to2);
	}

	@Test(expected = AssertionError.class)
	public void testUnssuccessfulConstruction() {
		ResultTO<String> to1 = new ResultTO<String>("Success"){};
		new ResultTO<String>(to1){};
	}
}