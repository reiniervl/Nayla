package com.rvlstudio.nayla.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

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

	@Test
	public void testCopyConstructor() {
		Credentials c1 = generateCredentials(false);
		Credentials c2 = new Credentials(c1);
		assertTrue("Matching credentials after copy constructor", c1.equals(c2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCopyConstructorNull() {
		new Credentials(null);
	}

	@Test
	public void testConstructor() {
		Credentials c1 = new Credentials("username", "password", "test@rvlstudio.com");
		Credentials c2 = new Credentials("username", "password", "test@rvlstudio.com");
		assertTrue("Matching credentials after paramatarized constructor", c1.equals(c2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorUsernameNull() {
		new Credentials(null, "password", "test@rvlstudio.com");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorPasswordNull() {
		new Credentials("username", null, "test@rvlstudio.com");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorEmailNull() {
		new Credentials("username", "password", null);
	}

	@Test
	public void testUsernameNotEqual() {
		Credentials c1 = new Credentials("username", "password", "test@rvlstudio.com");
		Credentials c2 = new Credentials("Different", "password", "test@rvlstudio.com");
		assertNotEquals("Username verschilt", c2, c1);
	}

	@Test
	public void testPasswordNotEqual() {
		Credentials c1 = new Credentials("username", "password", "test@rvlstudio.com");
		Credentials c2 = new Credentials("username", "Different", "test@rvlstudio.com");
		assertNotEquals("Password verschilt", c2, c1);
	}

	@Test
	public void testEmailNotEqual() {
		Credentials c1 = new Credentials("username", "password", "test@rvlstudio.com");
		Credentials c2 = new Credentials("username", "password", "different@rvlstudio.com");
		assertNotEquals("Email verschilt", c2, c1);
	}
	@Test
	public void testNotEqualNull() {
		assertFalse(generateCredentials(true).equals(null));
	}

	@Test
	public void testHashCode() {
		Credentials c1 = generateCredentials(true);
		Credentials c2 = generateCredentials(true);
		assertTrue("HashCode", c1.hashCode() != c2.hashCode());
	}

	@Test
	public void testClone() {
		Credentials c1 = generateCredentials(false);
		Credentials c2 = (Credentials) c1.clone();

		assertEquals(c1, c2);
	}

	@Test
	public void testToString() {
		assertTrue(generateCredentials(false).toString() != null);
	}

	@Test
	public void testSetters() {
		final String username = "username";
		final String password = "password";
		final String email = "test@rvlstudio.com";
		Credentials c = new Credentials();
		c.setUsername(username);
		c.setPassword(password);
		c.setEmail(email);

		assertEquals(username, c.getUsername());
		assertEquals(password, c.getPassword());
		assertEquals(email, c.getEmail());
	}

	public static Credentials generateCredentials(boolean random) {
		if(random) {
			return new Credentials(
				UUID.randomUUID().toString(), 
				UUID.randomUUID().toString(), 
				"test@rvlstudio.com");
		}
		return new Credentials("username", "password", "test@rvlstudio.com");
	}
}