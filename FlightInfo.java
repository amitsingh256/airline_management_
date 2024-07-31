package AirLine_Management;

import java.awt.Color;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.*;


public class FlightInfo extends JFrame {
	public FlightInfo() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JTable table= new JTable();
		try {
			Connect c= new Connect();
			String query = "SELECT * FROM FLIGHT_INFO";
			ResultSet rs = c.stmt.executeQuery(query);
	          table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (Exception e) {
			System.out.println(e);
		}
		JScrollPane jsp =new JScrollPane(table);
		jsp.setBounds(10,20,1000,600);
		add(jsp);
		
		setSize(1000,800);
		setLocation(200,100);
		setVisible(true);
	}
	
	
	
	
public static void main(String[] args) {
	new FlightInfo();
}
}
