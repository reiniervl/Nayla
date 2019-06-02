package com.rvlstudio.nayla.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

/**
 * OuderTest
 */
public class OuderTest {
	@Test
	public void testConstructor() {
		assertEquals(new Ouder().getClass(), Ouder.class);
	}

	@Test
	public void testCopyConstructor() {
		Ouder o1 = generateOuder(false);
		Ouder o2 = new Ouder(o1);
		assertEquals(o1, o2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCopyConstructorNull() {
		Ouder o1 = null;
		new Ouder(o1);
	}

	@Test
	public void testParamConstructor() {
		new Ouder(
			"voornaam",
			"achternaam",
			CredentialsTest.generateCredentials(false));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testParamConstructorVoornaamNull() {
		new Ouder(
			null,
			"achternaam",
			CredentialsTest.generateCredentials(false));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testParamConstructorAchternaamNull() {
		new Ouder(
			"voornaam",
			null,
			CredentialsTest.generateCredentials(false));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testParamConstructorCredentialsnaamNull() {
		new Ouder(
			"voornaam",
			"achternaam",
			null);
	}

	@Test
	public void testSetters() {
		final String voorNaam = "voornaam";
		final String achterNaam = "achternaam";
		final Credentials credentials = CredentialsTest.generateCredentials(false);
		final Kind kind1 = KindTest.generateKind(true);
		final Kind kind2 = KindTest.generateKind(true);
		final List<Kind> kinderen = new ArrayList<>();
		kinderen.add(kind1);
		kinderen.add(kind2);

		Ouder o = generateOuder(true);

		o.setVoorNaam(voorNaam);
		o.setAchterNaam(achterNaam);
		o.setCredentials(credentials);
		o.setKinderen(kinderen);

		assertEquals("voornaam", voorNaam, o.getVoorNaam());
		assertEquals("achternaam", achterNaam, o.getAchterNaam());
		assertEquals("credentials", credentials, o.getCredentials());
		assertEquals("kinderen", kinderen, o.getKinderen());
	}

	@Test
	public void testEqual() {
		assertTrue(generateOuder(false).equals(generateOuder(false)));
	}

	@Test
	public void testNotEqual() {
		assertFalse(generateOuder(false).equals(null));
	}

	@Test
	public void testNotEqualVoornaam() {
		Ouder o1 = generateOuder(false);
		Ouder o2 = generateOuder(false);
		o2.setVoorNaam("anders");

		assertFalse(o1.equals(o2));
	}

	@Test
	public void testNotEqualAchternaam() {
		Ouder o1 = generateOuder(false);
		Ouder o2 = generateOuder(false);
		o2.setAchterNaam("anders");

		assertFalse(o1.equals(o2));
	}

	@Test
	public void testNotEqualCredentials() {
		Ouder o1 = generateOuder(false);
		Ouder o2 = generateOuder(false);
		o2.setCredentials(CredentialsTest.generateCredentials(true));

		assertFalse(o1.equals(o2));
	}

	@Test
	public void testNotEqualKinderen() {
		Ouder o1 = generateOuder(false);
		Ouder o2 = generateOuder(false);

		final Kind kind1 = KindTest.generateKind(true);
		final Kind kind2 = KindTest.generateKind(true);
		final List<Kind> kinderen = new ArrayList<>();
		kinderen.add(kind1);
		kinderen.add(kind2);
		o2.setKinderen(kinderen);

		assertFalse(o1.equals(o2));
	}

	@Test
	public void testToString() {
		assertTrue(generateOuder(false).toString() != null);
	}

	@Test
	public void testHashCode() {
		Ouder o1 = generateOuder(true);
		Ouder o2 = generateOuder(true);
		assertNotEquals(o1.hashCode(), o2.hashCode());
	}

	public static Ouder generateOuder(boolean random) {
		Ouder o;
		if(random) {
			o = new Ouder(
				UUID.randomUUID().toString(),
				UUID.randomUUID().toString(),
				CredentialsTest.generateCredentials(random));

			final Kind kind1 = KindTest.generateKind(random);
			final Kind kind2 = KindTest.generateKind(random);
			final List<Kind> kinderen = new ArrayList<>();
			kinderen.add(kind1);
			kinderen.add(kind2);
			o.setKinderen(kinderen);
		} else {
			o = new Ouder(
				"voornaam",
				"achternaam",
				CredentialsTest.generateCredentials(random));
	
			final Kind kind1 = KindTest.generateKind(random);
			final Kind kind2 = KindTest.generateKind(random);
			final List<Kind> kinderen = new ArrayList<>();
			kinderen.add(kind1);
			kinderen.add(kind2);
			o.setKinderen(kinderen);
		}
		return o;
	}
}