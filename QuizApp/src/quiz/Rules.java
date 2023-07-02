package quiz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Rules extends JFrame  implements ActionListener{
	String name;
	JButton start,back;
	
Rules(String name){
	this.name = name;
	getContentPane().setBackground(Color.WHITE);
	setLayout(null);
	
	JLabel heading = new JLabel("Welcome "+name+" to Quiz Zone");
	heading.setBounds(50,20,700,45);
	heading.setFont(new Font("Viner IIand ITC",Font.BOLD,40));
	heading.setForeground(Color.blue);
	add(heading);
	
	JLabel rules = new JLabel();
	rules.setBounds(20,0,700,500);
	rules.setFont(new Font("Tahoma",Font.PLAIN,20));
	rules.setText(
			"<html>"+
	" "+"<br><br><br><br><br><br>"+
	"1. You are trained to be a programmer.Be wise while answering. no fraudulent conducts allowed "+"<br><br>"+
	"2. The participants shall not be allowed to use mobile or other electronic instruments during\r\n"
					+ "the quiz time."+"<br><br>"+
	"3. The questions shall be in the form of multiple choice, true/false statement, specific answer\r\n"
	+ "question etc."+"<br><br>"+
	"4. Audience/Supporters shall not give any hints or clues to the competitors "+"<br><br>"+
	"5. Replacement of any participant of a team is not allowed after registration."+"<br><br>"+
	"6. Time limit: 25 minutes."+ ""+"<br><br>"+
	"7. Each question will carry 1 mark."+"<br><br>"+
	"8. Response time for each question is 30 seconds."+
					
	"</html>"
			);
	add(rules);
		
	    back =new JButton("Back");
		back.setBounds(250, 540, 120, 25);
		back.setBackground(new Color(30,144,254));
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		start =new JButton("Start");
		start.setBounds(400, 540, 120, 25);
		start.setBackground(new Color(30,144,254));
		start.setForeground(Color.WHITE);
		start.addActionListener(this);
		
			add(start);
	setSize(800,650);
	setLocation(200,200);
	setVisible(true);
}
	
	public static void main(String[] args) {
		new Rules("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==start) {
			setVisible(false);
			new quiz(name);
		}else {
			setVisible(false);
			new login();
		}
		
	}

}
