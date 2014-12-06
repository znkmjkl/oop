package com.shapes.implementations;

import com.shapes.interfaces.Shape;

public class Rotated implements Shape {
	private float centerX;
	private float centerY;
	private float angle;
	private Shape shape;
	
	public Rotated(float centerX, float centerY, float angle, Shape shape){
		this.centerX = centerX;
		this.centerY = centerY;
		this.angle = angle;
		this.shape = shape;			
	}
	public boolean contains(float x, float y) {	
		
		double xNew = centerX + Math.cos(-angle) * (x - centerX) - Math.sin(-angle) * (y - centerY);
		double yNew = centerY + Math.sin(-angle) * (x - centerX) + Math.cos(-angle) * (y - centerY);
		
		if(shape.contains((float)xNew, (float)yNew))
			return true;
		return false;
	}
}