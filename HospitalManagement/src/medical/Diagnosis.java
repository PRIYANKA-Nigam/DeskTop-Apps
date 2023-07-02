package medical;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Statement;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;

public class Diagnosis extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTable table;
	JComboBox comboBox ;
	JTextArea txtrpatientSummary;
	String data="";
	Connection con = null;
	java.sql.Statement St = null;
	ResultSet Rt = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Diagnosis frame = new Diagnosis();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Diagnosis() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 851, 600);
		contentPane.add(contentPane_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 894, 80);
		contentPane_1.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Diagnosis Report");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(379, 47, 175, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Hospital Management System");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(285, 5, 374, 31);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 111, 46, 14);
		contentPane_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("SYMPTOMS");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(256, 111, 140, 14);
		contentPane_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("PATID");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(10, 146, 56, 14);
		contentPane_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_8 = new JLabel("NAME");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(10, 181, 66, 14);
		contentPane_1.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(89, 108, 135, 20);
		contentPane_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(411, 180, 135, 20);
		contentPane_1.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(411, 108, 135, 20);
		contentPane_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(89, 180, 135, 20);
		contentPane_1.add(textField_4);
		
		JLabel lblNewLabel_9 = new JLabel("DIAGNOSIS");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_9.setBounds(256, 146, 117, 14);
		contentPane_1.add(lblNewLabel_9);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(411, 145, 135, 20);
		contentPane_1.add(textField_6);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy","root","");
					PreparedStatement add = con.prepareStatement("insert into diagnosis values(?,?,?,?,?,?)");
					add.setInt(1, Integer.valueOf(textField.getText()));
					add.setString(2, comboBox.getSelectedItem().toString());
					add.setString(3, textField_4.getText());
					add.setString(4,textField_3.getText());
					add.setString(5, textField_6.getText());
					add.setString(6, textField_1.getText());
					int row = add.executeUpdate();
					JOptionPane.showMessageDialog(null, "Diagnosis data Added Successfully ...","Table Insertion",JOptionPane.PLAIN_MESSAGE);
					con.close();
					Selectional();
				}catch(Exception e1) {
					e1.printStackTrace();
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(49, 221, 89, 23);
		contentPane_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField.getText().isEmpty()||textField_1.getText().isEmpty()||textField_3.getText().isEmpty()
						||textField_4.getText().isEmpty()||textField_6.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Some Information seems missing.!!! Please fill all the required fields.","Table Updation",JOptionPane.PLAIN_MESSAGE);
				}else {
					try {
						con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy","root","");
						String q = "update diagnosis set name='"+textField_4.getText()+"'"+","+"symptoms='"+textField_3.getText()+"'"+","+"diagnosis='"
						+textField_6.getText()+"'"+","+"medicines='"+textField_1.getText()+"'"+","+"patid='"+comboBox.getSelectedItem()+"' where id="+textField.getText()+";";
						java.sql.Statement s =con.createStatement();
						s.executeUpdate(q);
						JOptionPane.showMessageDialog(null, "Data updated successfully ...","Table Updation",JOptionPane.PLAIN_MESSAGE);
						Selectional();
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(170, 221, 111, 23);
		contentPane_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "select the data to be deleted ...","Table Deletion",JOptionPane.PLAIN_MESSAGE);
				}else {
					try {
						con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy","root","");
						String id = textField.getText();
						String Query = "Delete from diagnosis where id="+id;
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
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(328, 221, 103, 23);
		contentPane_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CLEAR");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_6.setText("");
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBounds(475, 221, 96, 23);
		contentPane_1.add(btnNewButton_3);
		
		JLabel lblNewLabel_10 = new JLabel("Patient Diagnosis");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10.setBounds(365, 255, 140, 14);
		contentPane_1.add(lblNewLabel_10);
		
		JButton btnNewButton_4 = new JButton("HOME");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new HomeForm().setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_4.setBounds(399, 538, 89, 23);
		contentPane_1.add(btnNewButton_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(10, 710, 831, 39);
		contentPane_1.add(panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("MEDICINES");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(256, 183, 92, 14);
		contentPane_1.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 270, 816, 269);
		contentPane_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel df =(DefaultTableModel)table.getModel();
				int selected = table.getSelectedRow();
				textField.setText(df.getValueAt(selected, 0).toString());
				textField_1.setText(df.getValueAt(selected, 5).toString());
				textField_3.setText(df.getValueAt(selected, 3).toString());
				textField_4.setText(df.getValueAt(selected, 2).toString());
				textField_6.setText(df.getValueAt(selected, 4).toString());
				data="========================================\n\nName :"+textField_4.getText()+"\n----------------------\n"+"Symptoms :"+textField_3.getText()+"\n------------------\n"+
						"Diagnosis :"+textField_6.getText()+"\n---------------------\n"+"Medicines :"+textField_1.getText()+"\n========================================\n\n\t\t\tSummary Date :"+
						java.time.LocalDate.now();
				txtrpatientSummary.setText(txtrpatientSummary.getText()+"\n"+data);
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "PATID", "NAME", "SYMPTOMS", "DIAGNOSIS", "MEDICINES"
			}
		));
		
		 comboBox = new JComboBox();
		 comboBox.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		FetchName();
		 	}
		 });
		comboBox.setBounds(89, 144, 135, 22);
		contentPane_1.add(comboBox);
		
		JButton btnNewButton_5 = new JButton("PRINT");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					txtrpatientSummary.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_5.setBounds(649, 246, 89, 23);
		contentPane_1.add(btnNewButton_5);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(591, 86, 260, 158);
		contentPane_1.add(scrollPane_1);
		
		 txtrpatientSummary = new JTextArea();
		scrollPane_1.setViewportView(txtrpatientSummary);
		txtrpatientSummary.setFont(new Font("Monospaced", Font.BOLD, 15));
		txtrpatientSummary.setText("***********Patient Summary************");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setForeground(new Color(0, 0, 0));
		panel_2.setBounds(0, 564, 831, 10);
		contentPane_1.add(panel_2);
	
		GetPatient();	try {
			Selectional();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	private void GetPatient() {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy","root","");
			St = con.createStatement();
		String query="select * from dummy.patient";
			ResultSet rs =St.executeQuery(query);
			while(rs.next()) {
				String patId = rs.getString("id");
				comboBox.addItem(patId);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void FetchName() {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy","root","");
			St = con.createStatement();
		String query="select * from patient where id="+comboBox.getSelectedItem()+"";
			ResultSet rs =St.executeQuery(query);
			while(rs.next()) {
				String name = rs.getString("name");
				textField_4.setText(name);
			}
				
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void Selectional() throws SQLException {
		int a;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy","root","");
		PreparedStatement ps = con.prepareStatement("select * from diagnosis");
		ResultSet rs =ps.executeQuery();
		ResultSetMetaData rd =(ResultSetMetaData)rs.getMetaData();
		a= rd.getColumnCount();
		DefaultTableModel df =(DefaultTableModel)table.getModel();
		df.setRowCount(0);
		while(rs.next()) {
			Vector v = new Vector();
			for(int i=1;i<=a;i++) {
				v.add(rs.getString("id"));
				v.add(rs.getString("patid"));
				v.add(rs.getString("name"));
				v.add(rs.getString("symptoms"));
				v.add(rs.getString("diagnosis"));
				v.add(rs.getString("medicines"));
				
			}
			df.addRow(v);
		
	
		
}	
}
}
