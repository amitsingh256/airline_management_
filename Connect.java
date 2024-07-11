package AirLine_Management;

import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;


public class Connect {
	 Connection con;
	 Statement stmt;
  public Connect() throws ClassNotFoundException,SQLException {
	  		try {

		  		String driver="com.mysql.cj.jdbc.Driver";
		  		String url= "jdbc:mysql://localhost:3306/airline";
				String user="root";
				String password="Amitsingh@12";
				
				Class.forName(driver);   
				con= DriverManager.getConnection(url, user, password);
				stmt=con.createStatement();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	  }		
}	

