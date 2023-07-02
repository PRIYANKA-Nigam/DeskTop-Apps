package medical;
import java.util.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Janitors extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	static int c=1;String path="";
	JComboBox comboBox,comboBox_1,comboBox_2;
	JSpinner spinner,spinner_1;
	JRadioButton rdbtnNewRadioButton,rdbtnNewRadioButton_1;
	Connection con = null;
	java.sql.Statement St = null;
	ResultSet Rt = null;
	File f; 
	JLabel lblNewLabel_9;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janitors frame = new Janitors();
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
	public Janitors() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 795);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1360, 80);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Hospital Staff");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(572, 45, 175, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Hospital Management System");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(474, 5, 374, 31);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 91, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Age");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 129, 46, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(10, 166, 66, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Post");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(10, 207, 66, 14);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(105, 91, 203, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(105, 126, 203, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
	    comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cleaning Staff", "Compounder", "Dispensary Staff", "Pantry Staff", "Receptionist", "WatchMan"}));
		comboBox.setBounds(105, 203, 203, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_6 = new JLabel("Shift Time");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(10, 252, 84, 14);
		contentPane.add(lblNewLabel_6);
		
		 rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnNewRadioButton.setBounds(105, 162, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		 rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnNewRadioButton_1.setBounds(216, 162, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
	    ButtonGroup bg =new ButtonGroup();
	    bg.add(rdbtnNewRadioButton_1);
	    bg.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_7 = new JLabel("From");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(105, 252, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		 comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"AM", "PM"}));
		comboBox_1.setBounds(280, 250, 45, 32);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_8 = new JLabel("To");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(105, 291, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		 comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"AM", "PM"}));
		comboBox_2.setBounds(280, 288, 45, 31);
		contentPane.add(comboBox_2);
		
	   lblNewLabel_9 = new JLabel();
		lblNewLabel_9.setBounds(814, 116, 356, 162);
		contentPane.add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("UPLOAD");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(1003, 286, 130, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_10 = new JLabel("Profile");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10.setBounds(961, 91, 75, 14);
		contentPane.add(lblNewLabel_10);
		
		JButton btnBrowse = new JButton("BROWSE");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBrowse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser jf = new JFileChooser();
//				FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES","png","jpg","jpeg");
//				jf.addChoosableFileFilter(fnef);
				int sh = jf.showOpenDialog(null);
				if(sh == JFileChooser.APPROVE_OPTION) {
					f =jf.getSelectedFile();
				 path = f.getAbsolutePath();
					JOptionPane.showMessageDialog(null, "Image choosen from "+path,"Image Insertion",JOptionPane.PLAIN_MESSAGE);
					ImageIcon im = new javax.swing.ImageIcon(path);
					Image i = im.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
					lblNewLabel_9.setIcon(new ImageIcon(i));
					
				}
			}
		});
		btnBrowse.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBrowse.setBounds(863, 286, 130, 23);
		contentPane.add(btnBrowse);
		
		JButton btnNewButton_1 = new JButton("ADD");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				try { 
					c=(int) (c*Math.random());
					try {
						JModelList jml = new JModelList();
						JModel jm = new JModel();
						//jm.setId(c);
						jm.setName(textField.getText().trim());
//						jm.setAge(Integer.valueOf(textField_1.getText()).getAge());
						jm.setAge(Integer.valueOf(textField_1.getText()));
						String gen="";
						if(rdbtnNewRadioButton.isSelected()) {
							gen="Male";
						}else if(rdbtnNewRadioButton_1.isSelected()) {
							gen="Female";
						}
						jm.setGender(gen);
						jm.setPost(comboBox.getSelectedItem().toString());
						String time1 = spinner.getValue().toString()+" "+comboBox_1.getSelectedItem().toString();
						String[] t1 = time1.split(" ");
						String a = t1[3]+" "+t1[t1.length-1];
						String time2 = spinner_1.getValue().toString()+" "+comboBox_2.getSelectedItem().toString();
						String[] t2 = time2.split(" ");
						String b = t2[3]+" "+t2[t2.length-1];
						String time = "("+a+") To \n ("+b+")";
						jm.setTime(time);
						jm.setPhoto(Files.readAllBytes(f.toPath()));
						if(jml.create(jm)) {
							JOptionPane.showMessageDialog(null, "Success","Table Insertion",JOptionPane.PLAIN_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "Failed","Table Insertion",JOptionPane.PLAIN_MESSAGE);
						}
						Selectional();
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(),"Table Insertion",JOptionPane.PLAIN_MESSAGE);
					}
//					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy","root","");
//					PreparedStatement add = con.prepareStatement("insert into janitor values(?,?,?,?,?,?,?)");
//					add.setInt(1, c);
//					add.setString(2, textField.getText());
//					add.setInt(3, Integer.valueOf(textField_1.getText()));
//					String gen="";
//					if(rdbtnNewRadioButton.isSelected()) {
//						gen="Male";
//					}else if(rdbtnNewRadioButton_1.isSelected()) {
//						gen="Female";
//					}
//					add.setString(4, gen);
//					add.setString(5,comboBox.getSelectedItem().toString());
//					String time1 = spinner.getValue().toString()+" "+comboBox_1.getSelectedItem().toString();
//					String[] t1 = time1.split(" ");
//					String a = t1[3]+" "+t1[t1.length-1];
//					String time2 = spinner_1.getValue().toString()+" "+comboBox_2.getSelectedItem().toString();
//					String[] t2 = time2.split(" ");
//					String b = t2[3]+" "+t2[t2.length-1];
//					String time = "("+a+") To \n ("+b+")";
//					add.setString(6, time);
//				    add.setString(7, path);
//					int row = add.executeUpdate();
//					JOptionPane.showMessageDialog(null, "Staff data Added Successfully ...","Table Insertion",JOptionPane.PLAIN_MESSAGE);
//					c++;
//					con.close();
//					Selectional();
//				}catch(Exception e1) {
//					e1.printStackTrace();
//					
//				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(514, 128, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("DELETE");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "select the data to be deleted ...","Table Deletion",JOptionPane.PLAIN_MESSAGE);
				}else {
					try {
						con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy","root","");
						String id = textField.getText();
						String age = textField_1.getText();
						String Query = "Delete from janitor where age="+age;
						java.sql.Statement s =  con.createStatement();
						s.executeUpdate(Query);
						Selectional();
						JOptionPane.showMessageDialog(null, "Data successfully deleted ...","Table Deletion",JOptionPane.PLAIN_MESSAGE);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}	
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(670, 128, 95, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("UPDATE");
		btnNewButton_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField.getText().isEmpty()||textField_1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Some Information seems missing.!!! Please fill all the required fields.","Table Updation",JOptionPane.PLAIN_MESSAGE);
				}else {
					try {
						JModelList jml = new JModelList();
						JModel jm = new JModel();
						con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy","root","");
						String gen="";
						if(rdbtnNewRadioButton.isSelected()) {
							gen="Male";
						}else if(rdbtnNewRadioButton_1.isSelected()) {
							gen="Female";
						}
						String time1 = spinner.getValue().toString()+" "+comboBox_1.getSelectedItem().toString();
						String[] t1 = time1.split(" ");
						String a = t1[3]+" "+t1[t1.length-1];
						String time2 = spinner_1.getValue().toString()+" "+comboBox_2.getSelectedItem().toString();
						String[] t2 = time2.split(" ");
						String b = t2[3]+" "+t2[t2.length-1];
						String time = "("+a+") To \n ("+b+")";
						
//					File file = new File(path);
//					FileInputStream fi = new FileInputStream(file);
//					byte [] image = new byte[(int)file.length()];
//					fi.read(image);
//					
//						if(jml.updateImg(jm)) {
//							JOptionPane.showMessageDialog(null, "Success","Table Insertion",JOptionPane.PLAIN_MESSAGE);
//						}else {
//							JOptionPane.showMessageDialog(null, "Failed","Table Insertion",JOptionPane.PLAIN_MESSAGE);
//						}
						Icon icon = lblNewLabel_9.getIcon();
						BufferedImage bii = new BufferedImage(icon.getIconWidth(),icon.getIconHeight(),BufferedImage.TYPE_INT_RGB);
//						BufferedImage bii = (BufferedImage) ((ImageIcon) icon).getImage();
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						ImageIO.write(bii, ".jpg", baos);
						byte[] bytes = baos.toByteArray();
						String q = "update janitor set name='"+textField.getText()+"'"+","+"age='"+textField_1.getText()+"'"+","+"gender='"
						+gen+"'"+","+"post='"+comboBox.getSelectedItem()+"'"+","+"timing='"+time+"'"+","+"image='"+bytes.toString()+"' where age="+textField_1.getText()+";";
						java.sql.Statement s =con.createStatement();
						s.executeUpdate(q);
//						String q= "update janitor set name=?,age=?,gender=?,post=?,timing=? where age=?";
//						PreparedStatement s = con.prepareStatement(q);
//						s.setString(1,textField.getText());
//						s.setInt(2,Integer.valueOf(textField_1.getText()));
//						s.setString(3,gen);
//						s.setString(4,comboBox.getSelectedItem().toString());
//						s.setString(5,time);
//						s.setBytes(6,image);
//						s.executeUpdate();
//						s.close();
					if(s.executeUpdate(q)>0) {
						JOptionPane.showMessageDialog(null, "Data updated successfully ...","Table Updation",JOptionPane.PLAIN_MESSAGE);
					}
						Selectional();
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_2.setBounds(670, 207, 109, 23);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("CLEAR");
		btnNewButton_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
				textField_1.setText("");
				lblNewLabel_9.setIcon(null);
				bg.clearSelection();
			}
		});
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_3.setBounds(514, 203, 89, 23);
		contentPane.add(btnNewButton_1_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(10, 330, 1372, 29);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("Staff List");
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_11.setBounds(545, 0, 98, 24);
		panel_1.add(lblNewLabel_11);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 359, 1372, 316);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel df =(DefaultTableModel)table.getModel();
				int selected = table.getSelectedRow();
				textField.setText(df.getValueAt(selected, 0).toString());
				textField_1.setText(df.getValueAt(selected, 1).toString());
				String gen = df.getValueAt(selected, 2).toString();
				if(gen.equals("Male")) {
					rdbtnNewRadioButton.setSelected(true);
				}else if(gen.equals("Female")) {
					rdbtnNewRadioButton_1.setSelected(true);
				}
				String comb = df.getValueAt(selected, 3).toString();
				for(int i=0;i<comboBox.getItemCount();i++) {
					if(comboBox.getItemAt(i).toString().equalsIgnoreCase(comb)) {
						comboBox.setSelectedIndex(i);
					}
				}
				
				byte[] b = (byte[]) df.getValueAt(selected, 5);
				ByteArrayInputStream by = new ByteArrayInputStream(b);
				BufferedImage bi;
				try {
					bi = ImageIO.read(by);
				ImageIcon icon = new ImageIcon(bi.getScaledInstance( lblNewLabel_9.getWidth(), lblNewLabel_9.getHeight(), Image.SCALE_SMOOTH));
				 lblNewLabel_9.setIcon(icon); 
				 by.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
//				JLabel jl =(JLabel) df.getValueAt(selected, 5);
//				ImageIcon imm = (javax.swing.ImageIcon) jl.getIcon();
//			    lblNewLabel_9.setIcon(imm); 
				
				//table.getColumn("IMAGE").setCellRenderer(new My());
				table.getColumnModel().getColumn(5).setCellRenderer(new My());
				JLabel lebl=new JLabel("hello");
				ImageIcon im = new javax.swing.ImageIcon(path);
			//	table.setValueAt(im, i, 6);
				lebl.setIcon(im);
				
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NAME", "AGE", "GENDER", "POST", "TIMING", "IMAGE"
			}
		));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.BLACK);
		panel_1_1.setBounds(0, 720, 1360, 29);
		contentPane.add(panel_1_1);
		
		JButton btnNewButton_2 = new JButton("HOME");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new HomeForm().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(571, 674, 89, 23);
		contentPane.add(btnNewButton_2);
		
		Date date = new Date();
		SpinnerDateModel sm = new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY);
		SpinnerDateModel sm1 = new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY);
		
		 spinner = new JSpinner(sm);
		JSpinner.DateEditor de = new JSpinner.DateEditor(spinner,"HH:mm:ss");
		spinner.setEditor(de);
		spinner.setBounds(153, 251, 117, 31);
		contentPane.add(spinner);
		
		 spinner_1 = new JSpinner(sm1);
		JSpinner.DateEditor de1 = new JSpinner.DateEditor(spinner_1,"HH:mm:ss");
		spinner_1.setEditor(de1);
		spinner_1.setBounds(153, 289, 117, 30);
		contentPane.add(spinner_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(636, 91, 247, 181);
		separator.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setBounds(498, 176, 300, 29);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 0, 0));
		separator_2.setBackground(new Color(0, 0, 0));
		separator_2.setBounds(413, 80, 247, 249);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(0, 0, 0));
		separator_3.setBackground(new Color(0, 0, 0));
		separator_3.setBounds(498, 91, 304, 20);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(new Color(0, 0, 0));
		separator_4.setBackground(new Color(0, 0, 0));
		separator_4.setBounds(498, 273, 306, 32);
		contentPane.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(new Color(0, 0, 0));
		separator_5.setBackground(new Color(0, 0, 0));
		separator_5.setBounds(498, 94, 247, 182);
		separator_5.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(new Color(0, 0, 0));
		separator_6.setBackground(new Color(0, 0, 0));
		separator_6.setBounds(800, 94, 247, 182);
		separator_6.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(separator_6);
		try {
			Selectional();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	private void Selectional() throws SQLException {
		int a;
		JModelList jml = new JModelList();
		DefaultTableModel df = new DefaultTableModel();
//		df.addColumn("id");
		df.addColumn("name");
		df.addColumn("age");
		df.addColumn("gender");
		df.addColumn("post");
		df.addColumn("timing");
		df.addColumn("image");
		for(JModel jm : jml.findAll()) {
			df.addRow(new Object[] {
//					jm.getId(),
					jm.getName(),
					jm.getAge(),
					jm.getGender(),
					jm.getPost(),
					jm.getTime(),
					jm.getPhoto()
			});
			table.setModel(df);
			table.getTableHeader().setReorderingAllowed(false);
			table.getColumnModel().getColumn(5).setCellRenderer(new My());
		}
		
//		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy","root","");
//		PreparedStatement ps = con.prepareStatement("select * from janitor");
//		ResultSet rs =ps.executeQuery();
//		ResultSetMetaData rd =(ResultSetMetaData)rs.getMetaData();
//		a= rd.getColumnCount();
//		JLabel imageLabel = new JLabel();
//        ImageIcon imageicon = new ImageIcon(path);
//        Image img = imageicon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
//        imageLabel.setIcon(new ImageIcon(img));
//		DefaultTableModel df =(DefaultTableModel)table.getModel();
//		df.addRow(new Object[]{rs.getString("name"),rs.getString("age"),rs.getString("gender"),
//				rs.getString("post"),rs.getString("timing"),imageLabel});
//		df.setRowCount(0);
		
		
//		while(rs.next()) {
//			Vector v = new Vector();
//			for(int i=1;i<=a;i++) {
////				v.add(rs.getString("id"));
//				v.add(rs.getString("name"));
//				v.add(rs.getString("age"));
//				v.add(rs.getString("gender"));
//				v.add(rs.getString("post"));
//				v.add(rs.getString("timing"));
//			
//				//v.add(((Object) new ImageIcon(rs.getString("image"))).setCellRenderer(new My()));
//			//	v.add(new JLabel().setIcon(new javax.swing.ImageIcon(rs.getString("image"))));
//				v.add(rs.getBlob(rs.getString("image")));
//			}
//			df.addRow(v);
//		
//	
//		
//}	
}
	class My extends DefaultTableCellRenderer{

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			TableColumn tb = table.getColumn("image");
            tb.setMaxWidth(160);
            tb.setMinWidth(160);
            table.setRowHeight(160);
            byte[] bytes = (byte[]) value;
            ImageIcon im = new ImageIcon(new ImageIcon(bytes).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
            setIcon(im);
         setBorder(UIManager.getBorder("TableHeader.cellBorder"));
         setHorizontalAlignment(JLabel.CENTER);
         setBackground(getBackground());
			return this;
		}
		
	}
}
