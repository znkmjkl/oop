package com.shapes.implementations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.shapes.interfaces.Shape;

public class Intersection implements Shape {
	
	private Shape shape1;
	private Shape shape2;
	
	private List<Shape> fields = new ArrayList<Shape>();
	
	public Intersection(Shape shape1, Shape shape2) {	
		this.shape1 = shape1;
		this.shape2 = shape2;
	}

	public boolean contains(float x, float y) {
		return shape1.contains(x, y) && shape2.contains(x, y);
	}

	public Iterator<Shape> iterator() {
		
		fields.add(shape1);
		fields.add(shape2);
		
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
