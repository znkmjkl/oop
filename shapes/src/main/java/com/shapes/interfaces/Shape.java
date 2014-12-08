package com.shapes.interfaces;

import com.shapes.interfaces.Visitator;

public interface Shape {
	boolean contains(float x, float y);
	void accept(Visitator v);
}
