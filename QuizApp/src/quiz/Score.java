package quiz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Score extends JFrame implements ActionListener{
	int score=0;
	JButton submit;
Score(String name,int score){
	setBounds(400,150,750,550);
	getContentPane().setBackground(Color.WHITE);
	setLayout(null);
	ImageIcon imm =new javax.swing.ImageIcon("Images/score.jpg");	//scaled Image
	Image im =imm.getImage().getScaledInstance(550, 350, Image.SCALE_DEFAULT);
	JLabel image = new JLabel(new ImageIcon(im));
	image.setBounds(300, 100, 500, 300);
	add(image);
	
	JLabel heading = new JLabel("Thankyou "+name+" for playing Quiz");
	heading.setBounds(45,30,700,30);
	heading.setFont(new Font("Tahoma",Font.PLAIN,26));
	add(heading);
	
	JLabel marks = new JLabel("Your Score is "+score);
	marks.setBounds(45,100,700,30);
	marks.setFont(new Font("Tahoma",Font.PLAIN,26));
	add(marks);
	
	 submit = new JButton("Play Again");
	submit.setBounds(70, 250, 200, 40);
	submit.setFont(new Font("Tahoma",Font.PLAIN,22));
	submit.setBackground(new Color(30,144,255));
	submit.setForeground(Color.WHITE);
	submit.addActionListener(this);
	add(submit);
	setVisible(true); //writing this line is a must otherwise no frame will be visible
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new Score("",0);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== submit) {
			setVisible(false);
			new login();
		}
	}

}
