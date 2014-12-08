package com.shapes.implementations;

import com.shapes.interfaces.Shape;
import com.shapes.interfaces.Visitator;

public class Difference implements Shape {
	
	private Shape shape1;
	private Shape shape2;
	
	public Difference(Shape shape1, Shape shape2) {
		this.shape1 = shape1;
		this.shape2 = shape2;
	}
	
	public boolean contains(float x, float y) {		
		if(shape1.contains(x, y) && shape2.contains(x, y)){
			return false;
		} else if(shape1.contains(x, y)){			
			return true;
		}
		return false;		 
	}

	public void accept(Visitator v) {
		System.out.println("Difference");
	}

}
