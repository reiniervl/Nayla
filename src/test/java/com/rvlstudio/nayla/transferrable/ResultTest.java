package com.rvlstudio.nayla.transferrable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.rvlstudio.nayla.service.transferrable.Result;

import org.junit.Test;

/**
 * ResultTest
 */
public class ResultTest {
	@Test
	public void testResultSuccess() {
		Result r = Result.Success;
		assertEquals(0, r.getCode());
		assertTrue(r.getDescription() != null);
	}

	@Test
	public void testResultRegistratieMislukt() {
		Result r = Result.RegistratieMislukt;
		assertEquals(100, r.getCode());
		assertTrue(r.getDescription() != null);
	}
	
}