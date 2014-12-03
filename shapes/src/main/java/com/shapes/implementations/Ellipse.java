package com.shapes.implementations;

import java.awt.geom.Point2D;

import com.shapes.interfaces.Shape;

public class Ellipse implements Shape {

	private Point2D center;
	
	//a, b - radius
	float a;
	float b;
	
	public Ellipse(float a, float b){
		this.a = a;
		this.b = b;
		this.center = new Point2D.Float(0,0);
	}
	
	public float getA() {
		return a;
	}
	public void setA(float a) {
		this.a = a;
	}
	public float getB() {
		return b;
	}
	public void setB(float b) {
		this.b = b;
	}
	
	//TODO
	public boolean contains(float x, float y) {
		return false;
	}
}
