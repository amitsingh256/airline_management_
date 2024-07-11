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
			String query = "SELECT * FROM FLIGHT_DETAILS";
			ResultSet rs = c.stmt.executeQuery(query);
	          table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (Exception e) {
			System.out.println(e);
		}
		JScrollPane jsp =new JScrollPane(table);
		jsp.setBounds(00,20,900,600);
		add(jsp);
		
		setSize(900,600);
		setLocation(300,150);
		setVisible(true);
	}
	
	
	
	
public static void main(String[] args) {
	new FlightInfo();
}
}
