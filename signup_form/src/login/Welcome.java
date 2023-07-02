package login;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Welcome {

JLabel label = new JLabel();
JFrame frame = new JFrame();
JLabel wellabel =new JLabel();
JPanel redP =new JPanel();
JPanel greenP =new JPanel();
JPanel blueP =new JPanel();
public Welcome(String UserId) {
	super();
	wellabel.setBounds(0, 0, 200, 35);
	wellabel.setFont(new Font(null,Font.PLAIN,25));
	wellabel.setText("Hello "+UserId);
	redP.setBackground(Color.red);
	redP.setBounds(50,50,250,250);
	greenP.setBackground(Color.green);
	greenP.setBounds(250,50,250,250);
	blueP.setBackground(Color.blue);
	blueP.setBounds(0,300,500,250);
	label.setText("Hey! How u doin");
	ImageIcon icon = new ImageIcon("/image/p3.png");
	label.setIcon(icon);
	frame.add(wellabel);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(750,750);
	redP.add(label);
	frame.add(redP);frame.add(greenP);frame.add(blueP);
	JOptionPane.showMessageDialog(null, "This ia a warning dialog box","Imageicon not showing",JOptionPane.WARNING_MESSAGE);
	JOptionPane.showMessageDialog(null, "This ia an error dialog box","Imageicon not showing",JOptionPane.ERROR_MESSAGE);
	JOptionPane.showMessageDialog(null, "This ia an info dialog box","Imageicon not showing",JOptionPane.INFORMATION_MESSAGE);
	JOptionPane.showMessageDialog(null, "This ia a plain dialog box","Imageicon not showing",JOptionPane.PLAIN_MESSAGE);
	JOptionPane.showMessageDialog(null, "This ia a question dialog box","Imageicon not showing",JOptionPane.QUESTION_MESSAGE);
	JOptionPane.showConfirmDialog(null, "Hey! do u know me?","Imageicon not showing",JOptionPane.YES_NO_CANCEL_OPTION);
	String name=JOptionPane.showInputDialog("Who r u");
	System.out.println("hi "+name);
	
	String[] responses = {"No,you are welcome","Thank you","blush"};
	JOptionPane.showOptionDialog(null, "How r u?","See other dialog",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
			icon, null, 0);
	JOptionPane.showOptionDialog(null, "How r u?","Imageicon not showing",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
			icon, responses, 0);
	frame.setLayout(null);
	frame.setVisible(true);
}

}
