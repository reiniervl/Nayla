package com.rvlstudio.nayla.entity.data;

import com.rvlstudio.nayla.entity.AbstractEntity;
import com.rvlstudio.nayla.entity.KindTest;
import org.junit.Test;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Random;

import static org.junit.Assert.*;

public class TemperatuurTest {
	private static LocalDateTime tijd = LocalDateTime.now();

	@Test
	public void testConstructor() {
		Temperatuur temp = new Temperatuur();
		assertTrue(temp.getClass() == Temperatuur.class);
	}

	@Test
	public void testCopyConstructor() {
		Temperatuur temp1 = generate(false);
		Temperatuur temp2 = new Temperatuur(temp1);
		assertEquals(temp1, temp2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCopyConstructorNull() {
		new Temperatuur(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testParamConstructorKindNull() {
		new Temperatuur(null, tijd, 200);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testParamConstructorTijdNull() {
		new Temperatuur(KindTest.generateKind(false), null, 200);
	}

	@Test
	public void testgetGraden() {
		Temperatuur temp = generate(false);
		final double n = 38;
		temp.setGraden(n);
		assertEquals(n, temp.getGraden(), 0.000001);
	}

	@Test
	public void testEquals() {
		Temperatuur temp1 = generate(false);
		Temperatuur temp2 = generate(false);
		assertTrue(temp1.equals(temp2));
	}

	@Test
	public void testNotEqualsNull() {
		Temperatuur temp1 = generate(false);
		assertFalse(temp1.equals(null));
	}

	@Test
	public void testNotEquals() {
		Temperatuur temp1 = generate(false);
		Temperatuur temp2 = generate(false);
		temp2.setGraden(temp1.getGraden() + 1D);
		assertFalse(temp1.equals(temp2));
	}

	@Test
	public void testNotEqualType() {
		Temperatuur temp1 = generate(false);
		DataItem di = new DataItem(temp1) {
			private static final long serialVersionUID = 1L;
		};
		assertFalse(temp1.equals(di));
	}

	@Test
	public void testCompareTo() {
		Temperatuur temp1 = generate(false);
		Temperatuur temp2 = generate(false);
		assertEquals(0, temp1.compareTo(temp2));
	}

	@Test
	public void testCompareToNull() {
		Temperatuur temp1 = generate(false);
		assertEquals(1, temp1.compareTo(null));
	}

	@Test
	public void testCompareToLess() {
		Temperatuur temp1 = generate(false);
		Temperatuur temp2 = generate(false);
		temp2.setGraden(temp1.getGraden() - 2);
		assertTrue(temp1.compareTo(temp2) > 0);
	}

	@Test
	public void testCompareToGreather() {
		Temperatuur temp1 = generate(false);
		Temperatuur temp2 = generate(false);
		temp2.setGraden(temp1.getGraden() + 2);
		assertTrue(temp1.compareTo(temp2) < 0);
	}

	public static Temperatuur generate(boolean random) {
		Temperatuur temp = new Temperatuur(KindTest.generateKind(random), tijd, random ? new Random().nextInt(40) : 37);
		try {
			Field idField = AbstractEntity.class.getDeclaredField("id");
			idField.setAccessible(true);
			idField.set(temp, random ? new Random().nextInt(1000) : 2);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return temp;
	}
}
