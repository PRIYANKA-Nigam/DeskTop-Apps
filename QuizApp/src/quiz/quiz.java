package quiz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class quiz extends JFrame  implements ActionListener{
	static String question[][] = new String[10][5];
	static String answer[][] = new String[10][2];
	String userans[][]=new String[10][1];
	JLabel qno,questions;
	ButtonGroup b;
	JRadioButton obj,obj2,obj3,obj4;
	JButton next,submit,lifeline;
	public static int timer=15;
	public static int ans_given=0;
	public static int count=0,score=0;
	String username;
quiz(String username){
	this.username = username;
	setBounds(0,0,1400,850);
	getContentPane().setBackground(Color.WHITE);
	setLayout(null);
	JLabel image = new JLabel(new javax.swing.ImageIcon("Images/quizz.jpg"));
	image.setBounds(0, 0, 1400, 380);
	add(image);
	
	 qno = new JLabel();
	qno.setBounds(100,450,50,30);
	qno.setFont(new Font("Tahoma",Font.PLAIN,20));
	add(qno);
	
     questions = new JLabel();
	questions.setBounds(150,450,1000,30);
	questions.setFont(new Font("Tahoma",Font.PLAIN,20));
	add(questions);
	
	 question[0][0]= "Number of primitive data types in Java are?";
	    question[0][1]= "6";
	    question[0][2]= "7";
	    question[0][3]= "8";
	   question[0][4]="9";

	    question[1][0]= "What is the size of float and double in java?";
	    question[1][1]= "32 and 64";
	   question[1][2]="32 and 32";
	   question[1][3]= "64 and 64";
	   question[1][4]= "64 and 32";
	  

	   question[2][0]= "Automatic type conversion is possible in which of the possible cases?";
	 question[2][1]= "byte to int";
	   question[2][2]= "int to long";
	   question[2][3]= "long to int";
	   question[2][4]= "short to int";
	  

	   question[3][0]= "In which year Oracle took control of java after Sun-Microsystem";
	   question[3][1]=  "2005";
	    question[3][2]=  "2010";
	    question[3][3]=  "2007";
	   question[3][4]= "2000";
	    
	 
	   question[4][0]= "Select the valid statement.";
	   question[4][1]=  "char[] ch=new char(5)";
	   question[4][2]= "char[] ch=new char[5]";
	   question[4][3]="char[] ch=new char()";
	  question[4][4]=  "char[]ch=new char[]";
	  
	 
	 question[5][0]="When an array is passed to a method, what does the method receive?";
	  question[5][1]=  "A reference of the array";
	  question[5][2]= "A copy of the array";
	   question[5][3]= "Length of the array";
	  question[5][4]="Copy of first element";
	  

	   question[6][0]= "Select the valid statement to declare and initialize an array";
	   question[6][1]= "int[] a={}";
	   question[6][2]="int[] a={1,2,3}";
	  question[6][3]= "int[] a=(1,2,3)";
	  question[6][4]="int[][] a={1,2,3}";
	   

	  question[7][0]= "When is the object created with new keyword?";
	  question[7][1]=  "At runtime";
	  question[7][2]=  "At compile time";
	  question[7][3]=  "Depends on the code";
	  question[7][4]= "none";
	  
	  question[8][0]="Where can BLOB, CLOB, ARRAY, and REF type columns be updated?";
	  question[8][1]=  "JDBC1.0";
	  question[8][2]= "JDBC2.0";
	   question[8][3]= "JDBC3.0";
	  question[8][4]="JDBC4.0";
	  

	   question[9][0]= "What are the major components of the JDBC?";
	   question[9][1]= "DriverManager,Statement,ResultSet";
	   question[9][2]="DriverManager,Connection,Statement,ResultSet";
	  question[9][3]= "DriverManager,Driver,Connection,Statement,ResultSet";
	  question[9][4]="DriverManager,Driver,Connection,Statement";
	   


answer[0][1]="8";
answer[1][1]="32 and 64";
answer[2][1]="int to long";
answer[3][1]="2010";
answer[4][1]="char[] ch=new char[5]";
answer[5][1]="A reference of the array";
answer[6][1]="int[] a={1,2,3}";
answer[7][1]="At runtime";
answer[8][1]="JDBC3.0";
answer[9][1]="DriverManager,Driver,Connection,Statement,ResultSet";
	
    obj = new JRadioButton();
	obj.setBounds(170, 520, 700, 30);
	obj.setBackground(Color.WHITE);
	obj.setFont(new Font("Dialog",Font.PLAIN,20));
	add(obj);
	    obj2 = new JRadioButton();
		obj2.setBounds(170, 550, 700, 30);
		obj2.setBackground(Color.WHITE);
		obj2.setFont(new Font("Dialog",Font.PLAIN,20));
		add(obj2);

		   obj3 =new  JRadioButton();
			obj3.setBounds(170, 580, 700, 30);
			obj3.setBackground(Color.WHITE);
			obj3.setFont(new Font("Dialog",Font.PLAIN,20));
			add(obj3);

			  obj4 =new  JRadioButton();
				obj4.setBounds(170, 610, 700, 30);
				obj4.setBackground(Color.WHITE);
				obj4.setFont(new Font("Dialog",Font.PLAIN,20));
				add(obj4);
				
	 b =new ButtonGroup();
	b.add(obj);b.add(obj2);b.add(obj3);b.add(obj4);

    next = new JButton("Next");
	next.setBounds(1100, 510, 200, 40);
	next.setFont(new Font("Tahoma",Font.PLAIN,22));
	next.setBackground(new Color(30,144,255));
	next.setForeground(Color.WHITE);
	next.addActionListener(this);
	add(next);
	
	 lifeline = new JButton("50-50 LifeLine");
	lifeline.setBounds(1100, 570, 200, 40);
	lifeline.setFont(new Font("Tahoma",Font.PLAIN,22));
	lifeline.setBackground(new Color(30,144,255));
	lifeline.setForeground(Color.WHITE);
	lifeline.addActionListener(this);
	add(lifeline);
	
	 submit = new JButton("Submit");
	submit.setBounds(1100, 630, 200, 40);
	submit.setFont(new Font("Tahoma",Font.PLAIN,22));
	submit.setBackground(new Color(30,144,255));
	submit.setForeground(Color.WHITE);
	submit.setEnabled(false);
	submit.addActionListener(this);
	add(submit);
	
	start(count);
	
	setVisible(true);
}

	public void start(int i) {
	qno.setText(""+(i+1)+". ");
	questions.setText(question[i][0]);
	obj.setActionCommand(question[i][1]);
	obj.setText(question[i][1]);
	obj2.setActionCommand(question[i][2]);
	obj2.setText(question[i][2]);
	obj3.setActionCommand(question[i][3]);
	obj3.setText(question[i][3]);
	obj4.setActionCommand(question[i][4]);
	obj4.setText(question[i][4]);
	b.clearSelection();
	
	
}
	public void paint(Graphics g) {  //this is a method which is called automatically.No need to invoke it externally
		super.paint(g);
		String time ="Time left :"+timer+" seconds";
		g.setColor(Color.RED);
		g.setFont(new Font("Tahoma",Font.BOLD,25));
		if(timer>0) {
			g.drawString(time, 1100, 500);
		}else {
			g.drawString("Times Up", 1100, 500);
		}
		timer--;
		try {
			Thread.sleep(1000);
			repaint(); //this is use to decrement timer value by 1
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(ans_given==1) {
			ans_given=0;
			timer=15;
		}else if(timer<0) {
			timer=15;
			obj.setEnabled(true);
			obj2.setEnabled(true);
			obj3.setEnabled(true);
			obj4.setEnabled(true);
			
			if(count==8) {
				next.setEnabled(false);
				submit.setEnabled(true);
			}
			if(count==9) {
				if(b.getSelection()==null) {
					userans[count][0]="";
				}else {
					userans[count][0]=b.getSelection().getActionCommand();
				}
				for(int i=0;i<userans.length;i++) {
					if(userans[i][0].equals(answer[i][1])) {
						score+=10;
					}
				}
				setVisible(false);
				new Score(username,score);
				
			}else {
				if(b.getSelection()==null) {
					userans[count][0]="";
				}else {
					userans[count][0]=b.getSelection().getActionCommand();
				}
				count++;
				start(count);
			}
			
			
		}
	}

	public static void main(String[] args) {
		new quiz("");
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==next) {
			repaint();
			obj.setEnabled(true);
			obj2.setEnabled(true);
			obj3.setEnabled(true);
			obj4.setEnabled(true);
			ans_given=1;
			if(b.getSelection()==null) {
				userans[count][0]="";
			}else {
				userans[count][0]=b.getSelection().getActionCommand();
			}
		if(count==8) {
			next.setEnabled(false);
			submit.setEnabled(true);
		}
		
			count++;
			start(count);
		}
if(e.getSource()==submit) {
	ans_given=1;
	if(b.getSelection()==null) {
		userans[count][0]="";
	}else {
		userans[count][0]=b.getSelection().getActionCommand();
	}
	for(int i=0;i<userans.length;i++) {
		if(userans[i][0].equals(answer[i][1])) {
			score+=10;
		}
	}
	setVisible(false);
	new Score(username,score);
		}
if(e.getSource()==lifeline) {
	if(count==2||count==6||count==3||count==4||count==9) {
		obj.setEnabled(false);
		obj4.setEnabled(false);
	}else {
		obj2.setEnabled(false);
		obj4.setEnabled(false);
	}
	lifeline.setEnabled(false);
}
		
	}

}
