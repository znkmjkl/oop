package com.shapes.implementations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.shapes.implementations.*;

public class EllipseTest {
	
	@Test
	public void testEllipse() throws Exception {
		Ellipse e = new Ellipse(8, 10);
		
		assertTrue(e.contains(0, 0));		
		assertTrue(e.contains(0, 10));
		assertTrue(e.contains(8, 0));
		assertTrue(e.contains(5,5));
		assertTrue(e.contains(4, 5));
		assertTrue(e.contains(-5, -5));
		
		assertFalse(e.contains(10, 10));
		assertFalse(e.contains(7, 7));
		assertFalse(e.contains(-6,-8));
		
	}
}
