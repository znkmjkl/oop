package com.shapes.implementations;

import static junitparams.JUnitParamsRunner.$;

import java.awt.geom.Point2D;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class RectangleTest {

	private static final Object[] getRectanglesAndPoints1() {

		Rectangle rect = new Rectangle(new Point2D.Double(0, 0), 8, 10);
		Point2D point1 = new Point2D.Double(-4.99, -3.99);
		Point2D point2 = new Point2D.Double(4.99, 3.99);
		Point2D point3 = new Point2D.Double(0, 0);
		Point2D point4 = new Point2D.Double(0, 3.99);
		Point2D point5 = new Point2D.Double(2.5, 3.99);

		return $($(rect, point1), $(rect, point2), $(rect, point3), $(rect, point4), $(rect, point5));
	}

	private static final Object[] getRectanglesAndPoints2() {

		Rectangle rect = new Rectangle(new Point2D.Double(0, 0), 10, 10);
		Point2D point1 = new Point2D.Double(-5.01, -1);
		Point2D point2 = new Point2D.Double(2, 100);
		Point2D point3 = new Point2D.Double(-5.5, 8);
		Point2D point4 = new Point2D.Double(0, 5.01);
		Point2D point5 = new Point2D.Double(10, 15);

		return $($(rect, point1), $(rect, point2), $(rect, point3), $(rect, point4), $(rect, point5));
	}

	@Test
	@Parameters(method = "getRectanglesAndPoints1")
	public void containsShouldReturnTrue(Rectangle rect, Point2D point) {
		Assert.assertTrue(rect.contains((float) point.getX(), (float) point.getY()));
	}

	@Test
	@Parameters(method = "getRectanglesAndPoints2")
	public void containsShouldReturnFalse(Rectangle rect, Point2D point) {
		Assert.assertFalse(rect.contains((float) point.getX(), (float) point.getY()));
	}
}
