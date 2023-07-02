package login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class login_page implements ActionListener {

	private JPanel contentPane;
	JFrame frame =new JFrame();
	JButton loginB = new JButton("Login");
	JButton resetB = new JButton("Reset");
	JTextField userIdField = new JTextField();
	JPasswordField userPass = new JPasswordField();
	JLabel lab =new JLabel("UserId: ");
	JLabel lab2 =new JLabel("Password: ");
	JLabel mssg = new JLabel();
	
static HashMap<String,String> logininfo = new HashMap<String,String>();

	public static void main(String[] args) {
			login_page lp =new login_page(logininfo);	
	}

	/**
	 * Create the frame.
	 */
	public login_page(HashMap<String, String> logininfo) {
		this.logininfo = logininfo;
		lab.setBounds(50, 100, 75, 25);
		lab2.setBounds(50, 150, 75, 25);
		mssg.setBounds(125, 250, 250, 35);
		userIdField.setBounds(125, 100, 200, 25);
		userPass.setBounds(125, 150, 200, 25);
		loginB.setBounds(125, 200, 100, 25);
		loginB.addActionListener(this);
		loginB.setFocusable(false);
		resetB.setBounds(225, 200, 100, 25);
		resetB.addActionListener(this);
		resetB.setFocusable(false);
		mssg.setFont(new Font(null,Font.ITALIC,25));
		frame.add(lab); frame.add(lab2); frame.add(mssg);
		frame.add(userIdField); frame.add(userPass);
		frame.add(loginB);
		frame.add(resetB);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==resetB) {
			userIdField.setText("");
			userPass.setText("");
		}
		if(e.getSource()==loginB) {
			String userId = userIdField.getText();
			String pass= String.valueOf(userPass.getPassword());
			
			if(logininfo.containsKey(userId)) {
				if(logininfo.get(userId).equals(pass)) {
					mssg.setForeground(Color.GREEN);
					mssg.setText("Login Successful");
				//	frame.dispose(); // after entering details on the 1st window it will go off after redirecting us to 2nd window
					Welcome wel = new Welcome(userId);
				}else {
					mssg.setForeground(Color.RED);
					mssg.setText("Wrong Password .\nLogin Failed!!!!!!");
				}
			}else {
				mssg.setForeground(Color.RED);
//				dashboard wel = new dashboard();
				mssg.setText("Username not found");
			
				
			}
		}
		
	}

}
