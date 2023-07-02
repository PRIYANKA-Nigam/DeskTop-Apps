package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculatorApp implements ActionListener {

	JFrame frame;
	JTextField textfield;
	JButton[] numButton = new JButton[10];
	JButton[] functButton =new JButton[9];
	JButton addButton ,subB,mulB,divB,decB,equB,delB,clrB,negB;
	JPanel panel;
	Font myFont = new Font("Ink Free",Font.BOLD,10);
	double num1=0,num2=0,result=0;
	char operator;
	public static void main(String[] args) throws Exception {
		
					calculatorApp frame = new calculatorApp();
//					
	}

	/**
	 * Create the frame.
	 */
	public calculatorApp() throws Exception{
	frame = new JFrame("Calculator");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(420, 560);
	frame.getContentPane().setLayout(null);
	textfield =new JTextField();
	textfield.setBounds(50, 25, 300, 50);
	textfield.setFont(myFont);
	textfield.setEditable(false);
	frame.add(textfield);
	addButton = new JButton("+");
	subB = new JButton("-");
	mulB = new JButton("*");
	divB = new JButton("/");
	decB = new JButton(".");
	equB = new JButton("=");
	delB = new JButton("Delete");
	clrB = new JButton("Clear");
	negB = new JButton("(-)");
	functButton[0] = addButton;
	functButton[1] = subB;
	functButton[2] = mulB;
	functButton[3] = divB;
	functButton[4] = decB;
	functButton[5] = equB;
	functButton[6] = delB;
	functButton[7] = clrB;
	functButton[8] = negB;
	
	for(int i=0;i<9;i++) {
		functButton[i].addActionListener(this);
		functButton[i].setFont(myFont);
		functButton[i].setFocusable(false);
	}
	for(int i=0;i<10;i++) {
		numButton[i]=new JButton(String.valueOf(i));
		numButton[i].addActionListener(this);
		numButton[i].setFont(myFont);
		numButton[i].setFocusable(false);
	}
	delB.setBounds(150, 430, 100, 50);
	clrB.setBounds(250, 430, 100, 50);
	negB.setBounds(50, 430, 100, 50);
	frame.add(delB);
	frame.add(clrB);
	frame.add(negB);
	panel = new JPanel();
	panel.setBounds(50, 100, 300, 300);
	panel.setLayout(new GridLayout(4,4,10,10));
	
	  panel.add(numButton[1]); panel.add(numButton[2]); panel.add(numButton[3]);
	 
	panel.add(addButton);
	panel.add(numButton[4]);
	panel.add(numButton[5]);
	panel.add(numButton[6]);
//	panel.add(new JButton("4"));
//	panel.add(new JButton("5"));
//	panel.add(new JButton("6"));
//	JButton button = new JButton("6");
//	button.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//		}
//	});
//	panel.add(button);
	panel.add(subB);
	panel.add(numButton[7]);
	panel.add(numButton[8]);
	panel.add(numButton[9]);
	panel.add(mulB);
	panel.add(decB);
//	panel.add(new JButton("0"));
	panel.add(numButton[0]);
	panel.add(equB);
	panel.add(divB);
	frame.add(panel);
//	panel.setBackground(Color.GRAY);
	frame.getContentPane().add(panel);
	frame.getContentPane().add(delB);
	frame.getContentPane().add(clrB);
	frame.getContentPane().add(textfield);
	frame.setVisible(true);
	panel.setLayout(null);
//	frame.getContentPane().add(textfield);
//	
//	frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<10;i++) {
			if(e.getSource()==numButton[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
				
			}
		}
		if(e.getSource()==decB) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==addButton) {
			num1= Integer.parseInt(textfield.getText());
			operator='+';
			textfield.setText("");
		}
		
		if(e.getSource()==subB) {
			num1= Double.parseDouble(textfield.getText());
			operator='-';
			textfield.setText("");
		}
		
		if(e.getSource()==mulB) {
			num1= Double.parseDouble(textfield.getText());
			operator='*';
			textfield.setText("");
		}
		
		if(e.getSource()==divB) {
			num1= Double.parseDouble(textfield.getText());
			operator='/';
			textfield.setText("");
		}
		if(e.getSource()==equB) {
			num2= Integer.parseInt(textfield.getText());
			switch(operator) {
			case '+':
				result=num1+num2;break;
			case '-':
				result=num1-num2;break;
			case '*':
				result=num1*num2;break;
			case '/':
				result=num1/num2;break;	
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clrB) {
			textfield.setText("");
		}
		if(e.getSource()==delB) {
			String s = textfield.getText();
			textfield.setText("");
			for(int i=0;i<s.length()-1;i++) {
				textfield.setText(textfield.getText()+s.charAt(i));
			}
		}
		if(e.getSource()==negB) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
		
	}

}
