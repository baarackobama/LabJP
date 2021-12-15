package lab4;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EscButton extends JPanel {
	
	static int startX = 200,startY = 200;
	
	EscButton(){
		setPreferredSize(new Dimension(500,500));
		setLayout(null);
		Random rnd = new Random();
		JButton runButton = new JButton("Run");
		runButton.setBounds(startX,startY,100,50);
		runButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				checkIfCought(e,rnd,runButton);
			}
		});
		add(runButton);
		JButton resetButton = new JButton("Reset");
		resetButton.setBounds(340,380,100,50);
		resetButton.addActionListener(e->runButton.setLocation(startX,startY));
		add(resetButton);
		JButton paintButton = new JButton("Zmien na rysowanie");
		paintButton.setBounds(150,380,190,50);
		add(paintButton);
		paintButton.addActionListener(e -> {
			Okno.cl.show(Okno.panelCont,"1");
			Okno.kanwa.setFocusable(true);
		});
		}
	
	public static void checkIfCought(MouseEvent e,Random rnd,JButton runButton) {
		if(e.getY()<20) {
			System.out.println("Z³apany");
		}
		else {
			int x = rnd.nextInt(395);
			int y = rnd.nextInt(445);
			runButton.setLocation(x,y);
		}
	}

}
