package com.rvlstudio.nayla.entity.data;

import com.rvlstudio.nayla.entity.AbstractEntity;
import com.rvlstudio.nayla.entity.KindTest;
import org.junit.Test;

import java.lang.reflect.Field;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class DataItemTest {
	private static LocalDateTime tijd = LocalDateTime.now();

	@Test
	public void testConstructor() {
		new DataItem(){};
	}

	@Test
	public void testCopyConstructor() {
		DataItem di1 = generate(false);
		DataItem di2 = new DataItem(di1) {};
		assertEquals(di1, di2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCopyConstructorNull() {
		new DataItem(null) {};
	}

	@Test(expected = IllegalArgumentException.class)
	public void testParamConstructorKindNull() {
		DataItem di = new DataItem(null, tijd) {};
		try {
			Field idField = AbstractEntity.class.getDeclaredField("id");
			idField.setAccessible(true);
			idField.set(di, 2);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testParamConstructorTijdNull() {
		DataItem di = new DataItem(KindTest.generateKind(false), null) {};
		try {
			Field idField = AbstractEntity.class.getDeclaredField("id");
			idField.setAccessible(true);
			idField.set(di, 2);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEqual() {
		DataItem di1 = generate(false);
		DataItem di2 = generate(false);
		assertTrue(di1.equals(di2));
	}

	@Test
	public void testNotEqualNull() {
		DataItem di1 = generate(false);
		assertFalse(di1.equals(null));
	}

	@Test
	public void testNotEqualTijd() {
		DataItem di1 = generate(false);
		DataItem di2 = generate(false);
		di2.setTijd(null);
		assertFalse(di1.equals(di2));
	}

	@Test
	public void testNotEqualKind() {
		DataItem di1 = generate(false);
		DataItem di2 = generate(false);
		di2.setKind(null);
		assertFalse(di1.equals(di2));
	}

	@Test
	public void testToString() {
		DataItem di1 = generate(false);
		assertTrue(di1.toString() != null);
	}

	@Test
	public void testHashCode() {
		DataItem di1 = generate(false);
		di1.hashCode();
	}

	public static DataItem generate(boolean random) {
		DataItem di = new DataItem(KindTest.generateKind(random), tijd) {};
		try {
			Field idField = AbstractEntity.class.getDeclaredField("id");
			idField.setAccessible(true);
			idField.set(di, 2);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return di;
	}
}
