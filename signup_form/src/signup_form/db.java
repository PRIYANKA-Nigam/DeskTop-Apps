package signup_form;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.*;
public class db {
Connection con=null;
java.sql.PreparedStatement pst;
public static Connection dbconnect() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy","root","");
		return conn;
	}catch(Exception e) {
		System.out.println(e);
		return null;
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
