package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class ViewTest extends JFrame {

	private JPanel contentPane,panels,p2,p3,p4,p1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTest frame = new ViewTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewTest() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 188, 415);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel tab1 = new JPanel();
		tab1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				p1.setVisible(true);
				p2.setVisible(false);
				p3.setVisible(false);
				p4.setVisible(false);
				
			}
		});
		tab1.setBounds(10, 11, 168, 30);
		panel.add(tab1);
		
		JLabel j1 = new JLabel("Home");
		tab1.add(j1);
		
		JPanel tab2 = new JPanel();
		tab2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				p2.setVisible(true);
				p1.setVisible(false);
				p3.setVisible(false);
				p4.setVisible(false);
				
			}
			
		});
		tab2.setBounds(10, 41, 168, 30);
		panel.add(tab2);
		
		JLabel lblProfile = new JLabel("Profile");
		tab2.add(lblProfile);
		
		JPanel tab3 = new JPanel();
		tab3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				p3.setVisible(true);
				p2.setVisible(false);
				p1.setVisible(false);
				p4.setVisible(false);
				
			}
		});
		tab3.setBounds(10, 75, 168, 30);
		panel.add(tab3);
		
		JLabel j1_1_1 = new JLabel("About");
		tab3.add(j1_1_1);
		
		JPanel tab4 = new JPanel();
		tab4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				p4.setVisible(true);
				p2.setVisible(false);
				p3.setVisible(false);
				p1.setVisible(false);
				
			}
		});
		tab4.setBounds(10, 107, 168, 30);
		panel.add(tab4);
		
		JLabel j1_1_1_1 = new JLabel("Exit");
		tab4.add(j1_1_1_1);
		
	 panels = new JPanel();
		panels.setBackground(new Color(128, 64, 64));
		panels.setBounds(218, 11, 482, 415);
		contentPane.add(panels);
		panels.setLayout(null);
		
		 p2 = new JPanel();
		p2.setBackground(new Color(0, 128, 255));
		p2.setBounds(0, 0, 482, 410);
		panels.add(p2);
		p2.setLayout(null);
		
		JLabel image = new JLabel("");
//		Image img = new ImageIcon(this.getClass().getResource("Images/Priyanka.jpg")).getImage();
//		image.setIcon(new ImageIcon(img)); was giving me NullPointerException
		image.setIcon(new javax.swing.ImageIcon("Images/Priyanka.jpg"));
		image.setBounds(10, 118, 462, 281);
		p2.add(image);
		String[] imgName = {"a3.PNG","Priyanka.jpg","b1.PNG","b6.PNG","p4.png"};
		JButton prev = new JButton("Prev");
		prev.addActionListener(new ActionListener() { int count=4;
			public void actionPerformed(ActionEvent e) {
				ImageIcon[] imageIcon = new ImageIcon[5];
				for(int i=0;i<imgName.length;i++) {
					imageIcon[i] = new javax.swing.ImageIcon("Images/"+imgName[i]);
				}
				if(count>=0) {
					Image im = imageIcon[count].getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
					image.setIcon(new ImageIcon(im));
					count--;
				}
			}
		});
		prev.setBounds(74, 64, 89, 23);
		p2.add(prev);
		
		Icon i = image.getIcon();
		ImageIcon icon = (ImageIcon)i;  //Scaled up/down the image size
		Image im = icon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		image.setIcon(new ImageIcon(im));
		JButton next = new JButton("Next"); 
		next.addActionListener(new ActionListener() {
			int count=0;
			public void actionPerformed(ActionEvent e) {
				ImageIcon[] imageIcon = new ImageIcon[5];
				for(int i=0;i<imgName.length;i++) {
					imageIcon[i] = new javax.swing.ImageIcon("Images/"+imgName[i]);
					
//					image.setIcon(new javax.swing.ImageIcon("Images/"+imgName[i])); was showing only the last image
				}
				if(count<imgName.length) {
					Image im = imageIcon[count].getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
//					image.setIcon(imageIcon[count]);
					image.setIcon(new ImageIcon(im));
					count++;
				}

			}
		});
		next.setBounds(301, 64, 89, 23);
		p2.add(next);
		
		JLabel lblNewLabel = new JLabel("Home View");
		lblNewLabel.setBounds(74, 11, 268, 46);
		p2.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(128, 255, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBackground(new Color(0, 255, 128));
		
		
		
	 p3 = new JPanel();
		p3.setBackground(new Color(255, 0, 128));
		p3.setBounds(0, 0, 482, 410);
//		p2.add(p3);
		panels.add(p3);
		p3.setLayout(null);
		
	 p4 = new JPanel();
		p4.setBackground(new Color(128, 64, 0));
		p4.setBounds(0, 0, 482, 410);
//		p3.add(p4);
		panels.add(p4);
		p4.setLayout(null);
		
		 p1 = new JPanel();
		p1.setBackground(new Color(128, 128, 192));
		p1.setBounds(0, 0, 482, 410);
//		p4.add(p1);
		panels.add(p1);
		p1.setLayout(null);
	}
}
