package com.shapes.interfaces;

import java.util.Iterator;

public interface Shape extends Iterable<Shape> {
	boolean contains(float x, float y);
	void accept(Visitator v);
	Iterator<Shape> iterator();
}
