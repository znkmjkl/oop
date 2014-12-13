package com.shapes.implementations;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;

import java.awt.geom.Point2D;
import java.util.Iterator;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.shapes.interfaces.Shape;

@RunWith(JUnitParamsRunner.class)
public class IteratorTest {
	
	Shape rect = new Rectangle(new Point2D.Double(3, 3), 6, 4);
	Shape ellipse = new Ellipse(4, 2);
	
	Shape union = new Union(rect, ellipse);
	Shape diff = new Difference(rect, ellipse);
	Shape inter = new Intersection(rect, ellipse);
	Shape r = new Rotated(3, 3, (float)Math.PI/2, rect);
	Shape trans = new Translated(2, 1, rect);
	
	private final Object[] getIterators() {
		
		Iterator<Shape> i1 = rect.iterator();
		Iterator<Shape> i2 = ellipse.iterator();
		Iterator<Shape> i3 = union.iterator();
		Iterator<Shape> i4 = diff.iterator();
		Iterator<Shape> i5 = inter.iterator();
		Iterator<Shape> i6 = r.iterator();
		Iterator<Shape> i7 = trans.iterator();
		
		return  $($(i1, 0),
				$(i2, 0), 
				$(i3, 2), 
				$(i4, 2), 
				$(i5, 2),
				$(i6, 1),
				$(i7, 1));
	}
	
	@Test
	@Parameters(method = "getIterators")
	public void hasNextTest(Iterator iterator, int shapeNr) {
		
		for(int i = 0; i < shapeNr; i++) {
			Assert.assertEquals(iterator.hasNext(), true); iterator.next();
		}
		
		Assert.assertEquals(iterator.hasNext(), false);

	}

}
