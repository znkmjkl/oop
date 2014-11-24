package com.shapes.implementations;

import java.awt.geom.Point2D;

import com.shapes.interfaces.Shape;

public class Ellipse implements Shape {

	private Point2D center;
	
	//a, b - radius
	double a;
	double b;

	public Point2D getCenter() {
		return center;
	}
	public void setCenter(Point2D center) {
		this.center = center;
	}
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	
	//TODO
	public boolean contains(float x, float y) {
		return false;
	}
}
