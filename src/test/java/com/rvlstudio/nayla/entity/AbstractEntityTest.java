package com.rvlstudio.nayla.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.junit.Test;

/**
 * AbstractEntityTest
 */
public class AbstractEntityTest {
	@Test
	public void testConstructor() {
		AbstractEntity a = new AbstractEntity() {
			private static final long serialVersionUID = 1L;
		};
		assertTrue(a != null);
	}

	@Test
	public void testGetter() {
		AbstractEntity a = generateAbstractEntity(2);
		assertEquals(2, (int)a.getId());
	}

	@Test
	public void testEquals() {
		AbstractEntity a = generateAbstractEntity(2);
		AbstractEntity b = generateAbstractEntity(2);
		assertEquals(a, b);
	}

	@Test
	public void testNotEqual() {
		AbstractEntity a = generateAbstractEntity(1);
		AbstractEntity b = generateAbstractEntity(2);
		assertNotEquals(a, b);
	}

	@Test
	public void testNotEqualNull() {
		AbstractEntity a = generateAbstractEntity(2);
		AbstractEntity b = null;
		assertNotEquals(a, b);
	}

	@Test
	public void testHashCode() {
		AbstractEntity a = generateAbstractEntity(1);
		AbstractEntity b = generateAbstractEntity(2);
		assertNotEquals(a.hashCode(), b.hashCode());
	}

	@Test
	public void testToString() {
		assertTrue(generateAbstractEntity(2).toString() != null);
	}

	private static AbstractEntity generateAbstractEntity(Integer oid) {
		AbstractEntity a = new AbstractEntity() {
			private static final long serialVersionUID = 1L;
		};
		try {
			Field id = AbstractEntity.class.getDeclaredField("id");
			id.setAccessible(true);
			id.set(a, oid);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
}