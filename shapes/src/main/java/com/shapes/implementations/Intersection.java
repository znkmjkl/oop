package com.shapes.implementations;

import com.shapes.interfaces.Shape;

public class Intersection implements Shape {
	
	private Shape shape1;
	private Shape shape2;
	
	public Intersection(Shape shape1, Shape shape2) {
		this.shape1 = shape1;
		this.shape2 = shape2;
	}

	public boolean contains(float x, float y) {
		return shape1.contains(x, y) && shape2.contains(x, y);
	}

}
