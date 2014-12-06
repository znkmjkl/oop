package com.shapes.implementations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.shapes.interfaces.*;

public class RotatedTest {

	@Test
	public void testRotated() throws Exception {
		Rectangle shape = new Rectangle(6, 8);
		Rotated r = new Rotated(3, 3, (float)Math.PI/2, shape);
		
		assertTrue(r.contains(3, 3));
		assertTrue(r.contains(2, 2.9f));
		assertFalse(r.contains(0,4));
		assertFalse(r.contains(0, 0));		
		
	}
}
