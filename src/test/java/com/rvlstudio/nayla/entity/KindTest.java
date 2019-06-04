package com.rvlstudio.nayla.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

	@Test
	public void testCopyConstructor() {
		Kind k1 = generateKind(false);
		Kind k2 = new Kind(k1);

		assertEquals(k1, k2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCopyConstructorNull() {
		Kind k1 = null;
		new Kind(k1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testParamConstructorGeboorteDatumNull() {
		new Kind("voornaam", "achternaam", null,
				new Ouder("voornaam", "achternaam", CredentialsTest.generateCredentials(false)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testParamConstructorOuderNull() {
		new Kind("voornaam", "achternaam", KindTest.geboorteDatum, null);
	}

	@Test
	public void testSetters() {
		Kind k1 = generateKind(false);
		final LocalDate date = LocalDate.now().plusDays(30);

		k1.setGeboorteDatum(date);

		assertEquals(date, k1.getGeboorteDatum());
	}

	@Test
	public void testAddRemoveOuder() {
		Kind k1 = generateKind(false);
		final Ouder o1 = OuderTest.generateOuder(true);

		assertTrue(k1.addOuder(o1));
		assertTrue(k1.removeOuder(o1));
	}

	@Test
	public void testEqual() {
		final LocalDate date = LocalDate.now();
		Kind k1 = new Kind("voornaam", "achternaam", date,
				new Ouder("voornaam", "achternaam", CredentialsTest.generateCredentials(false)));
		Kind k2 = new Kind("voornaam", "achternaam", date,
				new Ouder("voornaam", "achternaam", CredentialsTest.generateCredentials(false)));

		assertTrue(k1.equals(k2));
	}

	@Test
	public void testNotEqualNull() {
		final LocalDate date = LocalDate.now();
		Kind k1 = new Kind("voornaam", "achternaam", date,
				new Ouder("voornaam", "achternaam", CredentialsTest.generateCredentials(false)));

		assertFalse(k1.equals(null));
	}

	@Test
	public void testNotEqualOuders() {
		final LocalDate date = LocalDate.now();
		Kind k1 = new Kind("voornaam", "achternaam", date,
				new Ouder("voornaam", "achternaam", CredentialsTest.generateCredentials(false)));
		Kind k2 = new Kind("voornaam", "achternaam", date,
				new Ouder("anders", "anders", CredentialsTest.generateCredentials(false)));

		assertFalse(k1.equals(k2));
	}

	@Test
	public void testNotEqualGeboorteDatum() {
		final LocalDate date = LocalDate.now();
		Kind k1 = new Kind("voornaam", "achternaam", date,
				new Ouder("voornaam", "achternaam", CredentialsTest.generateCredentials(false)));
		Kind k2 = new Kind("voornaam", "achternaam", date.plusDays(1),
				new Ouder("voornaam", "achternaam", CredentialsTest.generateCredentials(false)));

		assertFalse(k1.equals(k2));
	}

	public static Kind generateKind(boolean random) {
		if (random) {
			return new Kind(UUID.randomUUID().toString(), UUID.randomUUID().toString(), LocalDate.now(),
					new Ouder("voornaam", "achternaam", CredentialsTest.generateCredentials(random)));
		}
		return new Kind("voornaam", "achternaam", KindTest.geboorteDatum,
				new Ouder("voornaam", "achternaam", CredentialsTest.generateCredentials(random)));
	}
}