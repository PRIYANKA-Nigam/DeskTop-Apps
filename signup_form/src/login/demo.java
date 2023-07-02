package login;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class demo extends JFrame{
demo(){
	JLabel background;
	setSize(1200,700);
	setLayout(null);
	ImageIcon img = new ImageIcon("Images/Priyanka.jpg");
	Image im = img.getImage().getScaledInstance(700, 700, Image.SCALE_SMOOTH); //Image Resized
//	background = new JLabel("",img,JLabel.CENTER);
	background = new JLabel("",new ImageIcon(im),JLabel.CENTER);
	background.setBounds(0, 0, 1200, 700);
	add(background);
	setVisible(true);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
demo d =new demo();
	}

}
