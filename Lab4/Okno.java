package lab4;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
public class Okno extends JFrame {
	
	static CardLayout cl = new CardLayout();
	static JPanel panelCont,kanwa,escPanel;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Okno okno = new Okno();
			}
		});
	}
		
	Okno(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelCont = new JPanel();
		panelCont.setLayout(cl);
		panelCont.setPreferredSize(new Dimension(500,500));
		escPanel = new EscButton();
		kanwa = new Kanwa();
		
		panelCont.add(escPanel,"2");
		panelCont.add(kanwa,"1");
		
		cl.show(panelCont,"1");
		
		add(panelCont);
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
		

	}

}
