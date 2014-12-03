package com.shapes.implementations;

import com.shapes.interfaces.Shape;

public class Rotated implements Shape {
	private float x;
	private float y;
	private float angle;
	private Shape shape;
	
	public Rotated(float x, float y, float angle, Shape shape){
		this.x = x;
		this.y = y;
		this.angle = angle;
		this.shape = shape;			
	}
	//TODO0
	public boolean contains(float x, float y) {
		return false;
	}

}
