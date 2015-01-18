package com.shapes.implementations;
import com.shapes.interfaces.Visitator;

public class PrettyPrinting implements Visitator {
	
	private String space = "";
	
	public void visit(Difference difference) {		
		System.out.println(space + "Difference");
        
		space += "    ";
        difference.shape1.accept(this);
        difference.shape2.accept(this);
        space = space.substring(0, space.length() - 4);
	}

	
	public void visit(Ellipse ellipse) {
		System.out.println(space + "Ellipse(" + ellipse.a + ", " + ellipse.b + ")");
	}
	
	public void visit(Intersection intersection) {
		System.out.println(space + "Intersection");
		
		space += "    ";
        intersection.shape1.accept(this);
        intersection.shape2.accept(this);
        space = space.substring(0, space.length() - 4);
	}

	public void visit(Rectangle rectangle) {
		System.out.println(space + "Rectangle(" + rectangle.a + ", " + rectangle.b + ")");		
	}
	
	public void visit(Rotated rotated) {
		System.out.println(space + "Rotated(" + rotated.centerX + ", " + rotated.centerY + ", " + rotated.angle + ")");
		
		space += "    ";
    	rotated.shape.accept(this);
    	space = space.substring(0, space.length() - 4);
	}
	
	public void visit(Translated translated) {
		System.out.println(space + "Translated(" + translated.x + ", " + translated.y + ")");
		
		space+="    ";
    	translated.shape.accept(this);
    	space = space.substring(0, space.length() - 4);
	}

	public void visit(Union union) {
		System.out.println(space + "Union");
		
		space += "    ";
    	union.shape1.accept(this);
        union.shape2.accept(this);
        space = space.substring(0, space.length() - 4);		
	}
}
