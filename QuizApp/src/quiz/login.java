package quiz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.*;

public class login extends JFrame implements ActionListener{
	JButton rules,back;
	JTextField text;
	login(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		JLabel image = new JLabel(new javax.swing.ImageIcon("Images/quizz.jpg"));
		image.setBounds(0, 0, 710, 800);
		add(image);
		JLabel heading = new JLabel("Quiz Zone");
		heading.setBounds(750,60,300,45);
		heading.setFont(new Font("Viner IIand ITC",Font.BOLD,40));
		heading.setForeground(Color.blue);
		add(heading);
		
		JLabel name = new JLabel("Enter your name");
		name.setBounds(810,150,300,20);
		name.setFont(new Font("Mongolian Baiti",Font.BOLD,15));
		name.setForeground(Color.blue);
		add(name);
		
	    text = new JTextField();
		text.setBounds(735, 200, 300, 25);
		text.setFont(new Font("Times New Roman",Font.BOLD,20));
		add(text);
		
		 rules =new JButton("Play");
		rules.setBounds(735, 270, 120, 25);
		rules.setBackground(new Color(30,144,254));
		rules.setForeground(Color.WHITE);
		rules.addActionListener(this);
		add(rules);
		
	    back =new JButton("Back");
		back.setBounds(915, 270, 120, 25);
		back.setBackground(new Color(30,144,254));
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		setSize(1200,800);
		setLocation(200,200);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new login();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==rules) {
			setVisible(false);
			String name = text.getText();
			new Rules(name);
		}else if(e.getSource()==back) {
			setVisible(false);
		}
		
	}

}
