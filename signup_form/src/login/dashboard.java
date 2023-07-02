package login;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class dashboard extends JFrame {

	private JPanel contentPane;
//	private Image img = new ImageIcon(dashboard.class.getResource("res/p1.png")).getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT);
	private panelHome phome;
	private panelProfile pprofile;
	private panelView pview;
	private panelAbout pabout;
	private panelRate prate;
	ImageIcon icons = new ImageIcon("Priyanka.jpg");
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard frame = new dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public dashboard() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLocationRelativeTo(null);
//		setBounds(100, 100, 831, 481);
		contentPane = new JPanel();
		phome = new panelHome();
		pprofile = new panelProfile();
		pview = new panelView();
		pabout = new panelAbout();
		prate = new panelRate();
		
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 0, 64));
		panel.setBounds(0, 0, 269, 442);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel icon = new JLabel("My Panel");
		icon.setBackground(new Color(0, 128, 255));
		icon.setForeground(new Color(255, 255, 128));
		icon.setIcon(new ImageIcon("C:\\Users\\Hp\\Pictures\\Priyanka.jpg"));
		icon.setBounds(80, 11, 100, 118);
		panel.add(icon);
		
		JPanel home = new JPanel();
		home.addMouseListener(new PanelButtonMouseAdapter(home));
		home.setBounds(10, 140, 223, 36);
		panel.add(home);
		home.setLayout(null);
		
		JLabel Home = new JLabel("Home");
		Home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				phome.setVisible(true);
				pprofile.setVisible(false); 
				pview.setVisible(false); 
				pabout.setVisible(false); 
				prate.setVisible(false);
			}
		});
		Home.setForeground(new Color(0, 0, 0));
		Home.setBackground(new Color(0, 0, 0));
		Home.setBounds(10, 11, 106, 14);
		home.add(Home);
		
		JLabel pic = new JLabel("");
		pic.setIcon(new ImageIcon("C:\\Users\\Hp\\Pictures\\p4.png"));
		pic.setBounds(126, 0, 87, 36);
		home.add(pic);
		
		JPanel profit = new JPanel();
		profit.addMouseListener(new PanelButtonMouseAdapter(profit));
		profit.setBounds(10, 180, 223, 36);
		panel.add(profit);
		profit.setLayout(null);
		
		profit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				phome.setVisible(false);
				pprofile.setVisible(true); 
				pview.setVisible(false); 
				pabout.setVisible(false); 
				prate.setVisible(false);
			}
		});
		
		JLabel Home_1 = new JLabel("Profile");
		
		Home_1.setBounds(10, 11, 106, 14);
		Home_1.setForeground(Color.BLACK);
		Home_1.setBackground(Color.BLACK);
		profit.add(Home_1);
		
		JLabel pic_1 = new JLabel("");
		pic_1.setIcon(new ImageIcon("C:\\Users\\Hp\\Pictures\\p4.png"));
		pic_1.setBounds(126, 0, 87, 36);
		profit.add(pic_1);
		
		JPanel view = new JPanel();
		view.addMouseListener(new PanelButtonMouseAdapter(view));
		view.setBounds(10, 219, 223, 36);
		panel.add(view);
		view.setLayout(null);
	view.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				phome.setVisible(false);
				pprofile.setVisible(false); 
				pview.setVisible(true); 
				pabout.setVisible(false); 
				prate.setVisible(false);
			}
		});
		
		JLabel Home_2 = new JLabel("View");
		Home_2.setBounds(10, 11, 106, 14);
		Home_2.setForeground(Color.BLACK);
		Home_2.setBackground(Color.BLACK);
		view.add(Home_2);
		
		JLabel pic_2 = new JLabel("");
		pic_2.setIcon(new ImageIcon("C:\\Users\\Hp\\Pictures\\p4.png"));
		pic_2.setBounds(126, 0, 87, 36);
		view.add(pic_2);
		
		JPanel about = new JPanel();
		about.addMouseListener(new PanelButtonMouseAdapter(about));
		about.setBounds(10, 259, 223, 36);
		panel.add(about);
		about.setLayout(null);
		about.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				phome.setVisible(false);
				pprofile.setVisible(false); 
				pview.setVisible(false); 
				pabout.setVisible(true); 
				prate.setVisible(false);
			}
		});
		JLabel Home_3 = new JLabel("About");
		Home_3.setBounds(10, 11, 106, 14);
		Home_3.setForeground(Color.BLACK);
		Home_3.setBackground(Color.BLACK);
		about.add(Home_3);
		
		JLabel pic_3 = new JLabel("");
		pic_3.setIcon(new ImageIcon("C:\\Users\\Hp\\Pictures\\p4.png"));
		pic_3.setBounds(126, 0, 87, 36);
		about.add(pic_3);
		
		JPanel rateUs = new JPanel();
		pic_3.addMouseListener(new PanelButtonMouseAdapter(rateUs));
		rateUs.setBounds(10, 298, 223, 36);
		panel.add(rateUs);
		rateUs.setLayout(null);
		
		
		JLabel Home_4 = new JLabel("Rate Us");
		Home_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				phome.setVisible(false);
				pprofile.setVisible(false); 
				pview.setVisible(false); 
				pabout.setVisible(false); 
				prate.setVisible(true);
			}
		});
		Home_4.setBounds(10, 11, 106, 14);
		Home_4.setForeground(Color.BLACK);
		Home_4.setBackground(Color.BLACK);
		rateUs.add(Home_4);
		
		JLabel pic_4 = new JLabel("");
		pic_4.setIcon(new ImageIcon("C:\\Users\\Hp\\Pictures\\p4.png"));
		pic_4.setBounds(126, 0, 87, 36);
		rateUs.add(pic_4);
		
		JPanel Ask = new JPanel();
		pic_4.addMouseListener(new PanelButtonMouseAdapter(Ask));
		Ask.setBounds(10, 340, 223, 36);
		panel.add(Ask);
		Ask.setLayout(null);
		Ask.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this app","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
//					home.this.dispose();
					Ask.setForeground(Color.red);
					dispose();
				}
			}

		});
		JLabel Home_5 = new JLabel("Logout");
		Home_5.setBounds(10, 11, 106, 14);
		Home_5.setForeground(Color.BLACK);
		Home_5.setBackground(Color.BLACK);
		Ask.add(Home_5);
		
		JLabel pic_5 = new JLabel("");
		pic_5.setIcon(new ImageIcon("C:\\Users\\Hp\\Pictures\\p4.png"));
		pic_5.setBounds(126, 0, 87, 36);
		Ask.add(pic_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(291, 21, 514, 396);
		contentPane.add(panel_1);

		panel_1.setLayout(null);
		
		panel_1.add(phome);
	
		panel_1.add(pprofile);
		
		panel_1.add(pview);
		
		panel_1.add(pabout);
		panel_1.add(prate);
		
    
		
		
	}

	private class PanelButtonMouseAdapter extends MouseAdapter{
     JPanel panel;
     
		public PanelButtonMouseAdapter(JPanel panel) {
		super();
		this.panel = panel;
	}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseClicked(e);
			panel.setBackground(new Color(47,79,79));
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mousePressed(e);
			panel.setBackground(new Color(112,128,144));
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseReleased(e);
			panel.setBackground(new Color(60,179,113));
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseEntered(e);
			panel.setBackground(new Color(112,128,144));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseExited(e);
			panel.setBackground(new Color(112,128,144));
		}

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			// TODO Auto-generated method stub
			super.mouseWheelMoved(e);
			panel.setBackground(new Color(47,79,79));
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseDragged(e);
			panel.setBackground(new Color(60,179,113));
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseMoved(e);
			panel.setBackground(new Color(112,128,144));
		}
		
	}
	
}
