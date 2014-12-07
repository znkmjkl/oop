package com.shapes.implementations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.shapes.interfaces.Shape;


public class DifferenceTest {

	@Test
	public void testDiff() throws Exception {
	
		Rectangle shape1 = new Rectangle(10, 16);
		Ellipse shape2 = new Ellipse(6, 10);
		Rectangle shape3 = new Rectangle(6,8);
		
		Difference d = new Difference(shape1, shape2);
		
		assertTrue(d.contains(5, 6));
		assertTrue(d.contains(5, 8));
		
		assertFalse(d.contains(0, 0));
		assertFalse(d.contains(2, 2));
		assertFalse(d.contains(1, 2));
		assertFalse(d.contains(2, 1));	
		
		
		Difference d1 = new Difference(shape1, shape3);
		assertFalse(d1.contains(0, 0));
		assertFalse(d1.contains(8, 5));
		
		assertTrue(d1.contains(5, 8));		
		assertTrue(d1.contains(4, 4.5f));
			
	}
	
}
