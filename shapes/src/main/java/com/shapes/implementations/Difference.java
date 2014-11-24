package com.shapes.implementations;

import com.shapes.interfaces.Shape;

public class Difference implements Shape {
	
	private Shape shape1;
	private Shape shape2;
	
	public Difference(Shape shape1, Shape shape2) {
		this.shape1 = shape1;
		this.shape2 = shape2;
	}
	
	//TODO
	public boolean contains(float x, float y) {
		return false;
	}

}
