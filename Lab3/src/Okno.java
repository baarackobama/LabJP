import java.util.HashMap;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Okno implements ActionListener {
	HashMap<String,String> loginInfo = new HashMap<String,String>();
	
	
	Okno(){
		JFrame frame  =  new JFrame();
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextField loginField = new JTextField();
		JPasswordField passField  = new JPasswordField();
			
		JButton loginButton = new JButton("zaloguj");
		JButton resetButton = new JButton("reset");
		
		loginField.setBounds(50,100,400,30);
		passField.setBounds(50,150,400,30);
		loginButton.setBounds(400,200,50,30);
		resetButton.setBounds(450,200,50,30);
		
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login(loginInfo,loginField,passField,frame);
				
			}
			
		})};
/*		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
				
			}
			
		});*/
	public void login(HashMap<String,String> baza,JTextField loginField,JPasswordField passField,JFrame frame) {
		String login = loginField.getText();
		String password = String.valueOf(passField.getPassword());
			if(baza.containsKey(login)) {
				if(baza.get(login).equals(password)) {
					frame.setBackground(Color.green);
				}
			}
	}			
	}
