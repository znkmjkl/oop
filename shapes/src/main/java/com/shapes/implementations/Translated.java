package com.shapes.implementations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.shapes.interfaces.Shape;

public class Translated implements Shape {
	
	private Shape shape;
	
	private float x;
	private float y;
	
	private List<Shape> fields = new ArrayList<Shape>();
	
	public Translated(float x, float y, Shape shape) {
		this();
		this.shape = shape;
		this.x = x;
		this.y = y;
	}

	public Translated() {
	}

	public boolean contains(float x, float y) {	
		return shape.contains(x - this.x, y - this.y);
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
