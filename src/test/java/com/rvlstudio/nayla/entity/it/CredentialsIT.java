package com.rvlstudio.nayla.entity.it;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * CredentialsIT
 */
public class CredentialsIT {

	@Test
	public void testUrl() {
		String port = System.getProperty("liberty.test.port");
		assertEquals("port should be 9080", "9080", port);
	}
}