package com.shapes;

import com.shapes.implementations.PrettyPrintingVisitator;
import com.shapes.implementations.Rectangle;
import com.shapes.interfaces.Shape;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		Shape shape = new Rectangle(5f, 4f);
		shape.accept(new PrettyPrintingVisitator());
	}

}
