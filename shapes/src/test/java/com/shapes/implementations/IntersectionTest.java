package com.shapes.implementations;

import static junitparams.JUnitParamsRunner.$;

import java.awt.geom.Point2D;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class IntersectionTest {

	private static final Object[] getIntersectionsAndPoints1() {

		Rectangle rect1 = new Rectangle(new Point2D.Double(3, 3), 6, 4);
		Rectangle rect2 = new Rectangle(new Point2D.Double(5, 5), 4, 2);

		Intersection intersection = new Intersection(rect1, rect2);

		Point2D point1 = new Point2D.Double(4.99, 4);
		Point2D point2 = new Point2D.Double(4.49, 5.99);
		Point2D point3 = new Point2D.Double(4.01, 5);
		Point2D point4 = new Point2D.Double(4.01, 5.99);
		Point2D point5 = new Point2D.Double(4.99, 3.01);

		return $($(intersection, point1), $(intersection, point2), $(intersection, point3), $(intersection, point4),
				$(intersection, point5));
	}

	private static final Object[] getIntersectionsAndPoints2() {

		Rectangle rect1 = new Rectangle(new Point2D.Double(3, 3), 6, 4);
		Rectangle rect2 = new Rectangle(new Point2D.Double(5, 5), 4, 2);

		Intersection intersection = new Intersection(rect1, rect2);

		Point2D point1 = new Point2D.Double(20.99, 0);
		Point2D point2 = new Point2D.Double(5.5, 5);
		Point2D point3 = new Point2D.Double(4.06, 6.01);
		Point2D point4 = new Point2D.Double(2, 2);
		Point2D point5 = new Point2D.Double(5.99, 6.99);

		return $($(intersection, point1), $(intersection, point2), $(intersection, point3), $(intersection, point4),
				$(intersection, point5));
	}

	@Test
	@Parameters(method = "getIntersectionsAndPoints1")
	public void containsInShouldReturnTrue(Intersection intersection, Point2D point) {
		Assert.assertTrue(intersection.contains((float) point.getX(), (float) point.getY()));
	}

	@Test
	@Parameters(method = "getIntersectionsAndPoints2")
	public void containsShouldReturnFalse(Intersection intersection, Point2D point) {
		Assert.assertFalse(intersection.contains((float) point.getX(), (float) point.getY()));
	}
}
