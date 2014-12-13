package com.shapes.implementations;

import java.awt.geom.Point2D;
import java.util.Iterator;

import com.shapes.interfaces.Shape;

public class Rectangle implements Shape {
	private Point2D center;
	
	//a - vertical, b - horizontal
	private float a;
	private float b;
	
	public Rectangle(float a, float b) {
		this.center = new Point2D.Float(0,0);
		this.a = a;
		this.b = b;
	}
	
	public Rectangle(Point2D center, float a, float b) {
		this.center = center;
		this.a = a;
		this.b = b;		
	}
	
	public double getA() {
		return a;
	}
	public void setA(float a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(float b) {
		this.b = b;
	}
	public boolean contains(float x, float y) {
		
		double halfA = b/2;
		double halfB = a/2; 
		
		return ((x >= center.getX()-halfB && x <= center.getX()+halfB) && y >=center.getY()-halfA && y <= center.getY()+halfA);
	}

	public Iterator<Shape> iterator() {
		
        Iterator<Shape> it = new Iterator<Shape>() {

            public boolean hasNext() {
            	return false;
            }

            public Shape next() {
                return null;
            }

        };
        return it;
    }

}
