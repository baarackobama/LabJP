package figury;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AnimatorApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected static int state;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					final AnimatorApp frame = new AnimatorApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param delay 
	 */
	public AnimatorApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int ww = 540, wh = 300;
		setBounds((screen.width-ww)/2, (screen.height-wh)/2, ww, wh);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		AnimPanel kanwa = new AnimPanel();
		kanwa.setBounds(10, 11, 422, 219);
		contentPane.add(kanwa);
		
		
		
		JCheckBox cb1 = new JCheckBox("kwadraty");
		JCheckBox cb2 = new JCheckBox("kó³ka");
		JCheckBox cb3 = new JCheckBox("owale");
		cb1.setBounds(450,100,90,20);
		cb2.setBounds(450,125,90,20);
		cb3.setBounds(450,150,90,20);

		cb2.addActionListener(e -> {
			if(!cb2.isSelected()) {
				cb1.setEnabled(true);
				cb3.setEnabled(true);
			}
			else {
				state = 2;
				cb1.setEnabled(false);
				cb3.setEnabled(false);
				
			}
		});
		cb3.addActionListener(e -> {
			if(!cb3.isSelected()) {
				cb2.setEnabled(true);
				cb1.setEnabled(true);
			}
			else {
				state = 3;
				cb2.setEnabled(false);
				cb1.setEnabled(false);
				
			}
		});
		cb1.addActionListener(e -> {
			if(!cb1.isSelected()) {
				cb2.setEnabled(true);
				cb3.setEnabled(true);
			}
			else {
				state = 1;
				cb2.setEnabled(false);
				cb3.setEnabled(false);
				
			}
		});
		
		    
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				kanwa.initialize();
			}
		});
		contentPane.add(cb1);
		contentPane.add(cb2);
		contentPane.add(cb3);
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addFig();
			}
		});
		btnAdd.setBounds(10, 239, 80, 23);
		contentPane.add(btnAdd);
		//options = new int[] {1,2,3};
		JButton btnAnimate = new JButton("Animate");
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.animate();
			}
		});
		btnAnimate.setBounds(100, 239, 80, 23);
		contentPane.add(btnAnimate);
		
	}

}
