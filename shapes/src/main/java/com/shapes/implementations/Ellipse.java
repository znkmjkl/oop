package com.shapes.implementations;

import java.awt.geom.Point2D;

import com.shapes.interfaces.Shape;
import com.shapes.interfaces.Visitator;

public class Ellipse implements Shape {

	private Point2D center;
	float a;
	float b;
	
	public Ellipse(float a, float b){
		this.a = a;
		this.b = b;
		this.center = new Point2D.Float(0,0);
	}

	public boolean contains(float x, float y) {		
		double res =((x/a)*(x/a)) + ( (y/b)*(y/b) );		
		if (res <= 1)
			return true;		
		return false;
	}

	public void accept(Visitator v) {
		System.out.println("Ellipse");
	}
}
