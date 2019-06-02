package com.rvlstudio.nayla.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * PersoonTest
 */
public class PersoonTest {
	@Test
	public void testConstructor() {
		Persoon p = new Persoon() {
			private static final long serialVersionUID = 1L;
		};
		assertTrue(p != null);
	}

	@Test
	public void testCopyConstructor() {
		Persoon p1 = new Persoon("voornaam", "achternaam") {
			private static final long serialVersionUID = 1L;
		};
		Persoon p2 = new Persoon(p1) {
			private static final long serialVersionUID = 1L;
		};

		assertEquals(p1, p2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCopyConstructorNull() {
		new Persoon(null) {
			private static final long serialVersionUID = 1L;
		};
	}

	@Test
	public void testParamConstructor() {
		Persoon p = new Persoon("voornaam", "achternaam") {
			private static final long serialVersionUID = 1L;
		};
		assertTrue(p != null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testParamConstructorVoornaamNull() {
		new Persoon(null, "achternaam") {
			private static final long serialVersionUID = 1L;
		};
	}

	@Test(expected = IllegalArgumentException.class)
	public void testParamConstructorAchternaamNull() {
		new Persoon("voornaam", null) {
			private static final long serialVersionUID = 1L;
		};
	}

	@Test
	public void testSetters() {
		final String voor = "voornaam";
		final String achter = "achternaam";
		Persoon p = new Persoon() {
			private static final long serialVersionUID = 1L;
		};

		p.setVoorNaam(voor);
		p.setAchterNaam(achter);

		assertEquals(voor, p.getVoorNaam());
		assertEquals(achter, p.getAchterNaam());
	}

	@Test
	public void testEqual() {
		Persoon p1 = new Persoon("voornaam", "achternaam") {
			private static final long serialVersionUID = 1L;
		};
		Persoon p2 = new Persoon("voornaam", "achternaam") {
			private static final long serialVersionUID = 1L;
		};

		assertEquals(p1, p2);
	}

	@Test
	public void testNotEqualNull() {
		Persoon p1 = new Persoon("voornaam", "achternaam") {
			private static final long serialVersionUID = 1L;
		};

		assertFalse(p1.equals(null));
	}

	@Test
	public void testNotEqualVoornaam() {
		Persoon p1 = new Persoon("voornaam", "achternaam") {
			private static final long serialVersionUID = 1L;
		};
		Persoon p2 = new Persoon("anders", "achternaam") {
			private static final long serialVersionUID = 1L;
		};

		assertNotEquals(p1, p2);
	}

	@Test
	public void testNotEqualAchternaam() {
		Persoon p1 = new Persoon("voornaam", "achternaam") {
			private static final long serialVersionUID = 1L;
		};
		Persoon p2 = new Persoon("voornaam", "anders") {
			private static final long serialVersionUID = 1L;
		};

		assertNotEquals(p1, p2);
	}

	@Test
	public void testHashCode() {
		Persoon p1 = new Persoon("voornaam", "achternaam") {
			private static final long serialVersionUID = 1L;
		};
		Persoon p2 = new Persoon("anders", "anders") {
			private static final long serialVersionUID = 1L;
		};

		assertNotEquals(p1.hashCode(), p2.hashCode());
	}

	@Test
	public void testToString() {
		Persoon p1 = new Persoon("voornaam", "achternaam") {
		private static final long serialVersionUID = 1L;
	};
		assertTrue(p1.toString() != null);
	}
}