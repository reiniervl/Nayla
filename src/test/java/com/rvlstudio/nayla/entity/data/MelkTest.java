package com.rvlstudio.nayla.entity.data;

import com.rvlstudio.nayla.entity.AbstractEntity;
import com.rvlstudio.nayla.entity.KindTest;
import org.junit.Test;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Random;

import static org.junit.Assert.*;

public class MelkTest {
	private static LocalDateTime tijd = LocalDateTime.now();

	@Test
	public void testConstructor() {
		Melk melk = new Melk();
		assertTrue(melk.getClass() == Melk.class);
	}

	@Test
	public void testCopyConstructor() {
		Melk melk1 = generate(false);
		Melk melk2 = new Melk(melk1);
		assertEquals(melk1, melk2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCopyConstructorNull() {
		new Melk(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testParamConstructorKindNull() {
		new Melk(null, tijd, 200);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testParamConstructorTijdNull() {
		new Melk(KindTest.generateKind(false), null, 200);
	}

	@Test
	public void testSetMililiter() {
		Melk melk = generate(false);
		final int n = 100;
		melk.setMililiter(n);
		assertEquals(n, melk.getMililiter());
	}

	@Test
	public void testEquals() {
		Melk melk1 = generate(false);
		Melk melk2 = generate(false);
		assertTrue(melk1.equals(melk2));
	}

	@Test
	public void testNotEqualsNull() {
		Melk melk1 = generate(false);
		assertFalse(melk1.equals(null));
	}

	@Test
	public void testNotEquals() {
		Melk melk1 = generate(false);
		Melk melk2 = generate(false);
		melk2.setMililiter(melk1.getMililiter() + 20);
		assertFalse(melk1.equals(melk2));
	}

	@Test
	public void testCompareTo() {
		Melk melk1 = generate(false);
		Melk melk2 = generate(false);
		assertEquals(0, melk1.compareTo(melk2));
	}

	@Test
	public void testCompareToNull() {
		Melk melk1 = generate(false);
		assertEquals(1, melk1.compareTo(null));
	}

	@Test
	public void testCompareToLess() {
		Melk melk1 = generate(false);
		Melk melk2 = generate(false);
		melk2.setMililiter(melk1.getMililiter() - 20);
		assertTrue(melk1.compareTo(melk2) > 0);
	}

	@Test
	public void testCompareToGreather() {
		Melk melk1 = generate(false);
		Melk melk2 = generate(false);
		melk2.setMililiter(melk1.getMililiter() + 20);
		assertTrue(melk1.compareTo(melk2) < 0);
	}

	public static Melk generate(boolean random) {
		Melk melk = new Melk(KindTest.generateKind(random), tijd, random ? new Random().nextInt(1000) : 200);
		try {
			Field idField = AbstractEntity.class.getDeclaredField("id");
			idField.setAccessible(true);
			idField.set(melk, random ? new Random().nextInt(1000) : 2);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return melk;
	}
}