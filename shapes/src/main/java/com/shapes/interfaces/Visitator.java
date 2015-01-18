package com.shapes.interfaces;
import com.shapes.implementations.*;

public interface Visitator {

	public void visit(Difference difference);
	public void visit(Ellipse ellipse);
	public void visit(Intersection intersection);
	public void visit(Rectangle rectangle);
	public void visit(Rotated rotated);
	public void visit(Translated translated);
	public void visit(Union union);		
		
}
