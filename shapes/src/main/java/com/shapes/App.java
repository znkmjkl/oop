package com.shapes;

import java.awt.geom.Point2D;
import java.util.Iterator;

import com.shapes.implementations.Rectangle;
import com.shapes.implementations.Union;
import com.shapes.interfaces.Shape;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Rectangle rect1 = new Rectangle(new Point2D.Double(3, 3), 6, 4);
		Rectangle rect2 = new Rectangle(new Point2D.Double(5, 5), 4, 2);

		Union union = new Union(rect1, rect2);
		
	    Iterator<Shape> i = union.iterator();

	    while(i.hasNext()) {
	        System.out.println(i.next().getClass());
	    }
	}

}
