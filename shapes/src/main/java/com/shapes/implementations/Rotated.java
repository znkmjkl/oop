package com.shapes.implementations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.shapes.interfaces.Shape;

public class Rotated implements Shape {
	private float centerX;
	private float centerY;
	private float angle;
	private Shape shape;
	
	private List<Shape> fields = new ArrayList<Shape>();
	
	public Rotated() {
	}
	
	public Rotated(float centerX, float centerY, float angle, Shape shape) {
		this();
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
	
	public Iterator<Shape> iterator() {
		
		fields.add(shape);
		
		final Iterator fieldIt = fields.iterator();
		
        Iterator<Shape> it = new Iterator<Shape>() {

            public boolean hasNext() {
            	return fieldIt.hasNext();
            }

            public Shape next() {
                return (Shape) fieldIt.next();
            }

        };
        return it;
    }
}