package com.shapes.interfaces;

import java.util.Iterator;

public interface Shape extends Iterable<Shape> {
	boolean contains(float x, float y);
	Iterator<Shape> iterator();
}
