package figury;

import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Elipsa extends Figura implements ActionListener{
	Graphics2D buffer;
	int delay,width,height;
	
	
	Elipsa(Graphics2D buffer,int delay,int width,int height){
		
		super(buffer,delay,width,height);
		shape = new Ellipse2D.Float(0,0,10,10);
		aft = new AffineTransform();
		area = new Area(shape);
	}


}