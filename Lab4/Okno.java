package lab4;
import javax.swing.*;
import java.util.Random;

import java.awt.event.*;
public class Okno extends JFrame {
	public static void main(String[] args) {
		runMain();
	}
	
	public static void runMain() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Okno okno = new Okno();
			}
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
	Okno(){
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(5,5,495,495);
		panel.setLayout(null);
		setContentPane(panel);
		setLocationRelativeTo(null);
		Random rnd = new Random();
		JButton runButton = new JButton("Run");
		int startX = 200;
		int startY = 200;
		runButton.setBounds(startX,startY,100,50);
		setVisible(true);
		runButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				checkIfCought(e,rnd,runButton);
			}
		});
		panel.add(runButton);
		JButton resetButton = new JButton("Reset");
		resetButton.setBounds(340,380,100,50);
		resetButton.addActionListener(e->runButton.setLocation(startX,startY));
		panel.add(resetButton);
		JButton paintButton = new JButton("Zmien na rysowanie");
		paintButton.setBounds(150,380,190,50);
		panel.add(paintButton);
	}

}
