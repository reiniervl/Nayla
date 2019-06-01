package com.rvlstudio.nayla.entity;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * CredentialsTest
 */
public class CredentialsTest {
	@Test
	public void testClass() {
		Credentials c = new Credentials();
		assertTrue("Class is Credential", c.getClass() == Credentials.class);
	}
}