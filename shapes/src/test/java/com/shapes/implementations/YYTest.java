package com.shapes.implementations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.shapes.interfaces.Shape;

public class YYTest {

	@Test
	public void testContains() throws Exception {

	Shape yy = new Rotated(0, 0, (float) Math.PI,
			new Difference(
					new Union(
							new Difference(
									new Union(
											new Difference(
													new Ellipse(7, 7),
													new Intersection(
															new Translated(3, 0, new Rectangle(6, 12)),
															new Ellipse(6, 6)
															)
													),
													new Translated(0, 3, new Ellipse(3, 3))
											),
											new Translated(0, -3, new Ellipse(3, 3))
									),
									new Translated(0, -3, new Ellipse(1, 1))
							),
							new Translated(0, 3, new Ellipse(1, 1))
					));
	
	Shape test = new Difference(
			new Rotated(0, 0, (float) Math.PI / 6, new Ellipse(12, 8)),
			yy);
	
	PrettyPrinting pp = new PrettyPrinting();
	test.accept(pp);
	
	assertTrue(test.contains(-0.05539f, -2.936f));
	assertTrue(test.contains(-6.112f, -6.85f));
	assertTrue(test.contains(0.01846f, -3.6f));
	assertTrue(test.contains(4.376f, 8.069f));
	assertTrue(test.contains(8.438f, 0.9786f));

	assertFalse(test.contains(2.825f, -0.3508f));
	assertFalse(test.contains(7.626f, -7.884f));
	assertFalse(test.contains(0.09232f, 3.047f));
	assertFalse(test.contains(-6.629f, 1.496f));
	assertFalse(test.contains(-0.277f, -5.004f));
	assertFalse(test.contains(-2.049f, -3.674f));

	}
	
}
