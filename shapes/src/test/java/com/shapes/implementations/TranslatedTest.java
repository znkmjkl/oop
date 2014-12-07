package com.shapes.implementations;

import static junitparams.JUnitParamsRunner.$;

import java.awt.geom.Point2D;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class TranslatedTest {

	private static final Object[] getTranslatedAndPoints1() {

		Rectangle rect = new Rectangle(new Point2D.Double(3, 3), 6, 4);

		Translated translated = new Translated(2, 3, rect);

		Point2D point1 = new Point2D.Double(4, 4);
		Point2D point2 = new Point2D.Double(4, 8);
		Point2D point3 = new Point2D.Double(6.99, 7.99);
		Point2D point4 = new Point2D.Double(6, 7.01);
		Point2D point5 = new Point2D.Double(4.01, 4.01);

		return $($(translated, point1), $(translated, point2), $(translated, point3), $(translated, point4),
				$(translated, point5));
	}

	private static final Object[] getTranslatedAndPoints2() {

		Rectangle rect = new Rectangle(new Point2D.Double(3, 3), 6, 4);

		Translated translated = new Translated(2, 3, rect);

		Point2D point1 = new Point2D.Double(2.99, 2.99);
		Point2D point2 = new Point2D.Double(5, 2.99);
		Point2D point3 = new Point2D.Double(301.99, 6.01);
		Point2D point4 = new Point2D.Double(8, 2.99);
		Point2D point5 = new Point2D.Double(16.01, 4.01);

		return $($(translated, point1), $(translated, point2), $(translated, point3), $(translated, point4),
				$(translated, point5));
	}

	@Test
	@Parameters(method = "getTranslatedAndPoints1")
	public void containsInShouldReturnTrue(Translated translated, Point2D point) {
		Assert.assertTrue(translated.contains((float) point.getX(), (float) point.getY()));
	}

	@Test
	@Parameters(method = "getTranslatedAndPoints2")
	public void containsShouldReturnFalse(Translated translated, Point2D point) {
		Assert.assertFalse(translated.contains((float) point.getX(), (float) point.getY()));
	}
}
