package figury;

import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

public class RoundRec extends Figura{
	Graphics2D buffer;
	int delay,width,height;
	
	
	RoundRec(Graphics2D buffer,int delay,int width,int height){
		
		super(buffer,delay,width,height);
		shape = new RoundRectangle2D.Float(0,0,20,30,20,30);
		aft = new AffineTransform();
		area = new Area(shape);
	}

}
