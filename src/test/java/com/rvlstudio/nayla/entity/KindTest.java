package com.rvlstudio.nayla.entity;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.Test;

/**
 * KindTest
 */
public class KindTest {
	private static LocalDate geboorteDatum = LocalDate.now();

	@Test
	public void testConstructor() {
		assertTrue(new Kind().getClass() == Kind.class);
	} 

	public static Kind generateKind(boolean random) {
		if(random) {
			return new Kind(
				UUID.randomUUID().toString(),
				UUID.randomUUID().toString(),
				LocalDate.now(),new Ouder(
					"voornaam",
					"achternaam",
					CredentialsTest.generateCredentials(random)));
		}
		return new Kind(
			"voornaam",
			"achternaam",
			KindTest.geboorteDatum,
			new Ouder(
				"voornaam",
				"achternaam",
				CredentialsTest.generateCredentials(random)));
	}
}