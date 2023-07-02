package signup_form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
public class successPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtAddTaskTo;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					successPage frame = new successPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con=null;
	private JTextField txtSearchTodoData;
	public successPage() {
		con = (Connection)db.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 906, 481);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Todo List");
		lblNewLabel.setFont(new Font("Stencil", Font.BOLD, 25));
		lblNewLabel.setBounds(320, 22, 177, 28);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(317, 48, 131, 10);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Important Task");
		lblNewLabel_1.setBounds(42, 68, 95, 21);
		contentPane.add(lblNewLabel_1);
		
		txtAddTaskTo = new JTextField();
		txtAddTaskTo.setText("Add Task to do");
		txtAddTaskTo.setBounds(172, 67, 177, 28);
		contentPane.add(txtAddTaskTo);
		txtAddTaskTo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Other Task");
		lblNewLabel_2.setBounds(42, 115, 95, 28);
		contentPane.add(lblNewLabel_2);
		
		JTextArea txtrAddAnotherTask = new JTextArea();
		txtrAddAnotherTask.setText("Add another task");
		txtrAddAnotherTask.setForeground(new Color(255, 255, 255));
		txtrAddAnotherTask.setBackground(new Color(0, 0, 0));
		txtrAddAnotherTask.setBounds(172, 110, 177, 210);
		contentPane.add(txtrAddAnotherTask);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String imp = txtAddTaskTo.getText();
				String other = txtrAddAnotherTask.getText();
			
				try {
					 PreparedStatement	 pst = con.prepareStatement("insert into todo(important,other) values(?,?)");
					pst.setString(1, imp);
					pst.setString(2, other); 
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "data Inserted to db successfully ...");
					txtAddTaskTo.setText("");
					txtrAddAnotherTask.setText("");
					viewData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(22, 350, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel df =(DefaultTableModel)table.getModel();
				int s =table.getSelectedRow();
				int id = Integer.parseInt(df.getValueAt(s, 0).toString());
				try {
					String imp=txtAddTaskTo.getText();
					String other = txtrAddAnotherTask.getText();
					 PreparedStatement	pst =con.prepareStatement("update todo set important=?,other=? where id=?");
					pst.setString(1, imp);
					pst.setString(2, other);
					pst.setInt(3, id);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "List Updated");
					txtAddTaskTo.setText("");
					txtrAddAnotherTask.setText("");
					viewData();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(133, 350, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Done");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(249, 350, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(408, 69, 472, 304);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S.No", "Important Task", "Other Task"
			}
		));
		
		JButton btnNewButton_3 = new JButton("View");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					viewData();
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_3.setBounds(22, 386, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Delete");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel df =(DefaultTableModel)table.getModel();
				int selected = table.getSelectedRow();
				int id = Integer.parseInt(df.getValueAt(selected, 0).toString());
				 PreparedStatement pst;
				try {
					pst = con.prepareStatement("delete from todo where id="+id);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "data Deleted successfully ...");
					viewData();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_4.setBounds(133, 386, 89, 21);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Reset");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAddTaskTo.setText("");
				txtrAddAnotherTask.setText("");
			}
		});
		btnNewButton_5.setBounds(249, 384, 89, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Export to Text File");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = "C:\\Users\\Hp\\eclipse-workspace\\signup_form\\data.txt";
				File file = new File(path);
				try {
					FileWriter fw = new FileWriter(file);
					BufferedWriter bw =new BufferedWriter(fw);
					for(int i=0;i<table.getRowCount();i++) {
						for(int j=0;j<table.getColumnCount();j++) {
							bw.write(table.getValueAt(i, j).toString()+" ");
						}
						bw.newLine();
					}
					bw.close();
					fw.close();
					JOptionPane.showMessageDialog(null, "Exported data in text File ...");
				}catch(IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_6.setBounds(408, 384, 143, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Import from Text File");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = "C:\\Users\\Hp\\eclipse-workspace\\signup_form\\data.txt";
				File file = new File(path);
				try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				Object[] lines = br.lines().toArray();
				for(int i=0;i<lines.length;i++) {
					String[] row = lines[i].toString().split(" ");
					model.addRow(row);
				}
				}catch(FileNotFoundException e1) {
					e1.printStackTrace();
				}
					
					
				
			}
		});
		btnNewButton_7.setBounds(591, 384, 152, 23);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Clear");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getRowCount();
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				for(int j=0;j<i;j++) {
					dtm.removeRow(0);
				}
			}
		});
		btnNewButton_8.setBounds(791, 384, 89, 23);
		contentPane.add(btnNewButton_8);
		
		txtSearchTodoData = new JTextField();
		txtSearchTodoData.setText("Search Todo Data");
		txtSearchTodoData.setBounds(591, 46, 206, 22);
		contentPane.add(txtSearchTodoData);
		txtSearchTodoData.setColumns(10);
		
		JButton btnNewButton_9 = new JButton("Search");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchData = txtSearchTodoData.getText();
				ArrayList<Modal> users = ListUsers(searchData);
		        DefaultTableModel model = new DefaultTableModel();
		        model.setColumnIdentifiers(new Object[]{"id","important","other"});
		        Object[] row = new Object[4];
		        
		        for(int i = 0; i < users.size(); i++)
		        {
		            row[0] = users.get(i).getId();
		            row[1] = users.get(i).getA();
		            row[2] = users.get(i).getB();
		          
		            model.addRow(row);
		        }
		       table.setModel(model);
			}

			private ArrayList<Modal> ListUsers(String searchData) {
				
				ArrayList<Modal> usersList = new ArrayList<Modal>();
		        
		        Statement st;
		        ResultSet rs;
		        
		        try{
		            Connection con = db.dbconnect();
		            st = con.createStatement();
		            String searchQuery = "SELECT * FROM `todo` WHERE CONCAT(`id`, `important`,`other`) LIKE '%"+searchData+"%'";
		            rs = st.executeQuery(searchQuery);
		            
		            Modal modal;
		            
		            while(rs.next())
		            {
		                modal = new Modal(
		                                 rs.getInt("id"),
		                                 rs.getString("important"),
		                                 rs.getString("other")
		                                );
		                usersList.add(modal);
		            }
		            
		        }catch(Exception ex){
		            System.out.println(ex.getMessage());
		        }
		        
		        return usersList;
			}
		});
		btnNewButton_9.setBounds(791, 46, 89, 23);
		contentPane.add(btnNewButton_9);
		table.getColumnModel().getColumn(1).setPreferredWidth(107);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel df =(DefaultTableModel)table.getModel();
				int selected = table.getSelectedRow();
				int id = Integer.parseInt(df.getValueAt(selected, 0).toString());
				txtAddTaskTo.setText(df.getValueAt(selected, 1).toString());
				txtrAddAnotherTask.setText(df.getValueAt(selected, 2).toString());
				btnNewButton.setEnabled(false);
			}
		});
	}
	public void viewData() throws SQLException {
		int a;
		PreparedStatement ps = con.prepareStatement("select * from todo");
		ResultSet rs =ps.executeQuery();
		ResultSetMetaData rd =(ResultSetMetaData)rs.getMetaData();
		a= rd.getColumnCount();
		DefaultTableModel df =(DefaultTableModel)table.getModel();
		df.setRowCount(0);
		while(rs.next()) {
			Vector v = new Vector();
			for(int i=1;i<=a;i++) {
//				v.add(rs.getString("id"));
				v.add(rs.getString("important"));
				v.add(rs.getString("other"));
			}
			df.addRow(v);
		}
	}
}
