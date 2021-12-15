package figury;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Area;

public class Kwadrat extends Figura implements ActionListener {
	
	Graphics2D buffer;
	int delay,width,height;
	
	
	Kwadrat(Graphics2D buffer,int delay,int width,int height){
		
		super(buffer,delay,width,height);
		shape = new Rectangle2D.Float(0,0,10,10);
		aft = new AffineTransform();
		area = new Area(shape);
		
	}



}