package com.shapes.implementations;

import java.awt.geom.Point2D;

import com.shapes.interfaces.Shape;

public class Rectangle implements Shape {
	private Point2D center;
	
	//a - vertical, b - horizontal
	private double a;
	private double b;
	
	public Rectangle(Point2D center, double a, double b) {
		this.center = center;
		this.a = a;
		this.b = b;
	}

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
	public boolean contains(float x, float y) {
		
		double halfA = a/2;
		double halfB = b/2; 
		
		return ((x >= center.getX()-halfB && x <= center.getX()+halfB) && y >=center.getY()-halfA && y <= center.getY()+halfA);
	}
	
}
