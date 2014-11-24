package com.shapes.implementations;

import static junitparams.JUnitParamsRunner.$;

import java.awt.geom.Point2D;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class UnionTest {

	private static final Object[] getUnionsAndPoints1() {

		Rectangle rect1 = new Rectangle(new Point2D.Double(3, 3), 6, 4);
		Rectangle rect2 = new Rectangle(new Point2D.Double(5, 5), 4, 2);

		Union union = new Union(rect1, rect2);

		Point2D point1 = new Point2D.Double(1.01, 0.01);
		Point2D point2 = new Point2D.Double(4.5, 4);
		Point2D point3 = new Point2D.Double(5.99, 6.99);
		Point2D point4 = new Point2D.Double(1.01, 5.99);
		Point2D point5 = new Point2D.Double(4.01, 6.99);

		return $($(union, point1), $(union, point2), $(union, point3), $(union, point4), $(union, point5));
	}

	private static final Object[] getUnionsAndPoints2() {

		Rectangle rect1 = new Rectangle(new Point2D.Double(3, 3), 6, 4);
		Rectangle rect2 = new Rectangle(new Point2D.Double(5, 5), 4, 2);

		Union union = new Union(rect1, rect2);

		Point2D point1 = new Point2D.Double(0.99, 0);
		Point2D point2 = new Point2D.Double(-5.01, 2.99);
		Point2D point3 = new Point2D.Double(3.99, 6.01);
		Point2D point4 = new Point2D.Double(0.99, 5);
		Point2D point5 = new Point2D.Double(6.01, 7.01);

		return $($(union, point1), $(union, point2), $(union, point3), $(union, point4), $(union, point5));
	}

	@Test
	@Parameters(method = "getUnionsAndPoints1")
	public void containsInShouldReturnTrue(Union union, Point2D point) {
		Assert.assertTrue(union.contains((float) point.getX(), (float) point.getY()));
	}

	@Test
	@Parameters(method = "getUnionsAndPoints2")
	public void containsShouldReturnFalse(Union union, Point2D point) {
		Assert.assertFalse(union.contains((float) point.getX(), (float) point.getY()));
	}
}
