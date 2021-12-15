package lab4;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Kanwa extends JPanel{

	
	private static final String kwadrat = "K";
    private static final String owal = "O";
    private static final int IFW = Kanwa.WHEN_IN_FOCUSED_WINDOW;
    private static Random rand = new Random();
	private int xMouse,yMouse,whatDraw = 0;
	private static int r,gr,b;
	
	Kanwa(){
	
	Random rand = new Random();
	
	getInputMap(IFW).put(KeyStroke.getKeyStroke("K"), kwadrat);
	getInputMap(IFW).put(KeyStroke.getKeyStroke("O"), owal);
	getActionMap().put(kwadrat, new Kwadrat());
	getActionMap().put(owal, new Owal());
	
	
	setPreferredSize(new Dimension(500,500));
	setLayout(null);
	JButton escButton = new JButton("Zmien na uciekaj¹cy przycisk");
	escButton.setBounds(0,0,250,50);
	add(escButton);
	escButton.addActionListener(e -> { Okno.cl.show(Okno.panelCont,"2");});
	}	
	
	private class Kwadrat extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			whatDraw=2;
			whereMouse();
			repaint();
			
		}
		
	}
	
	private class Owal extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			whatDraw=1;
			whereMouse();
			repaint();
		}
		
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		r=rand.nextInt(256);
		gr=rand.nextInt(256);
		b=rand.nextInt(256);
		Graphics2D g2d = (Graphics2D) g;
	    g2d.setColor(new Color(r,gr,b));
		if(whatDraw==1) {
		    g2d.fillOval(xMouse,yMouse,50,50);
			whatDraw=0;
		}
		else if(whatDraw==2) {
			g2d.fillRect(xMouse,yMouse,50,50);
			whatDraw=0;
		}
		
	}

	private void whereMouse() {
		Point p = MouseInfo.getPointerInfo().getLocation();
		xMouse = p.x - getLocationOnScreen().x-20;
		yMouse = p.y - getLocationOnScreen().y-20;
	}

}