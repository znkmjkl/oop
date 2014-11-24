package com.shapes.implementations;

import com.shapes.interfaces.Shape;

public class Translated implements Shape {
	
	private Shape shape;
	
	private float x;
	private float y;
	
	public Translated(float x, float y, Shape shape) {
		this.shape = shape;
		this.x = x;
		this.y = y;
	}

	public boolean contains(float x, float y) {	
		return shape.contains(x - this.x, y - this.y);
	}

}
