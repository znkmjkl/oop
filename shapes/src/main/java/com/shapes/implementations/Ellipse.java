package com.shapes.implementations;

import java.awt.geom.Point2D;
import java.util.Iterator;

import com.shapes.interfaces.Shape;
import com.shapes.interfaces.Visitator;

public class Ellipse implements Shape {

	private Point2D center;
	public float a;
	public float b;
	
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
	
	public Ellipse(float a, float b) {
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
	
	public void accept(Visitator v) {
		v.visit(this);		
	}
}
