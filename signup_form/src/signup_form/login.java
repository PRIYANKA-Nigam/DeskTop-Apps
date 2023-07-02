package signup_form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con=null;
	public login() {
		con = (Connection)db.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 478);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 64, 128));
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setBounds(277, 11, 102, 23);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 128, 128));
		separator.setBounds(277, 32, 60, 10);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(64, 79, 88, 32);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(258, 85, 176, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mobile : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(64, 153, 88, 32);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(258, 159, 176, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name=textField.getText();
					String mob = textField_1.getText();
					PreparedStatement pst = con.prepareStatement("select * from sign where name=? and mob=?");
					pst.setString(1,name);
					pst.setString(2, mob);
					ResultSet r =pst.executeQuery();
					if(r.next()) {
						successPage s =new successPage();
						s.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "incorrect id or pwd");;
					}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Stencil", Font.BOLD, 22));
		btnNewButton.setBounds(194, 260, 117, 38);
		contentPane.add(btnNewButton);
	}
}
