import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Okno implements ActionListener {

	Map<String,String> loginInfo = new HashMap<>();

	
	Okno(){
		
		
		loginInfo.put("admin","haslo");
		loginInfo.put("user", "123");
		
		
		
		JFrame frame  =  new JFrame();
		frame.setSize(500,300);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextField loginField = new JTextField();
		JPasswordField passField  = new JPasswordField();
		JLabel loginLabel = new JLabel("login");
		JLabel passLabel = new JLabel("haslo");
			
		JButton loginButton = new JButton("zaloguj");
		JButton resetButton = new JButton("reset");
		
		loginLabel.setBounds(20,20,400,30);
		passLabel.setBounds(20,70,400,30);
		loginField.setBounds(50,50,400,30);
		passField.setBounds(50,100,400,30);
		loginButton.setBounds(250,150,100,30);
		resetButton.setBounds(350,150,100,30);

		
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent aActionEvent) {
				login(loginInfo,loginField,passField,frame);
				
			}
		});
		frame.add(loginLabel);
		frame.add(passLabel);
		frame.add(loginField);
		frame.add(passField);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.setVisible(true);
		
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reset(loginField,passField);
				
			}
			
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void login(Map<String,String> baza,JTextField loginField,JPasswordField passField,JFrame frame) {
		String login = loginField.getText();
		String password = String.valueOf(passField.getPassword());
			if(baza.containsKey(login)) {
				if(baza.get(login).equals(password)) {
					frame.getContentPane().setBackground(Color.green);
				}
				else {
					frame.getContentPane().setBackground(Color.red);
				}
			}
			else {
				frame.getContentPane().setBackground(Color.red);
			}
	}
	public void reset(JTextField loginField,JPasswordField passField) {
		loginField.setText("");
		passField.setText("");
	}
}
