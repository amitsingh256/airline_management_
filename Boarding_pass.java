package AirLine_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Boarding_pass extends JFrame implements ActionListener {

	JTextField tfpnr;
	JLabel tfname, tfnationality, lblsrc, lbldest, labelfname, labelfcode, labeldate;
	JButton fetchButton;

	public Boarding_pass() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel heading = new JLabel("AIR INDIA");
		heading.setBounds(380, 10, 450, 35);
		heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
		add(heading);

		JLabel subheading = new JLabel("Boarding Pass");
		subheading.setBounds(360, 50, 300, 30);
		subheading.setFont(new Font("Tahoma", Font.PLAIN, 24));
		subheading.setForeground(Color.BLUE);
		add(subheading);

		JLabel lblaadhar = new JLabel("PNR NO.: ");
		lblaadhar.setBounds(60, 100, 150, 25);
		lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblaadhar);

		tfpnr = new JTextField();
		tfpnr.setBounds(180, 100, 200, 25);
		add(tfpnr);

		fetchButton = new JButton("Enter");
		fetchButton.setBackground(Color.BLACK);
		fetchButton.setForeground(Color.WHITE);
		fetchButton.setBounds(380, 100, 120, 25);
		fetchButton.addActionListener(this);
		add(fetchButton);

		JLabel lblname = new JLabel("NAME :");
		lblname.setBounds(60, 140, 150, 25);
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblname);

		tfname = new JLabel();
		tfname.setBounds(220, 140, 150, 25);
		add(tfname);

		JLabel lblnationality = new JLabel("NATIONALITY :");
		lblnationality.setBounds(60, 180, 150, 25);
		lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblnationality);

		tfnationality = new JLabel();
		tfnationality.setBounds(220, 180, 150, 25);
		add(tfnationality);

		JLabel lblsrc = new JLabel("SOURCE :");
		lblsrc.setBounds(60, 220, 150, 25);
		lblsrc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblsrc);

		lblsrc = new JLabel();
		lblsrc.setBounds(220, 220, 150, 25);
		add(lblsrc);

		JLabel lbldest = new JLabel("DEST. :");
		lbldest.setBounds(380, 220, 150, 25);
		lbldest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lbldest);

		lbldest = new JLabel();
		lbldest.setBounds(540, 220, 150, 25);
		add(lbldest);

		JLabel lblfname = new JLabel("Flight Name :");
		lblfname.setBounds(60, 260, 150, 25);
		lblfname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblfname);

		labelfname = new JLabel();
		labelfname.setBounds(220, 260, 150, 25);
		add(labelfname);

		JLabel lblfcode = new JLabel("Flight Code :");
		lblfcode.setBounds(380, 260, 150, 25);
		lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblfcode);

		labelfcode = new JLabel();
		labelfcode.setBounds(540, 260, 150, 25);
		add(labelfcode);

		JLabel lbldate = new JLabel("Date :");
		lbldate.setBounds(60, 300, 150, 25);
		lbldate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lbldate);

		labeldate = new JLabel();
		labeldate.setBounds(220, 300, 150, 25);
		add(labeldate);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Airline_Management/icons/Air.logo.png"));
		Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
		ImageIcon image = new ImageIcon(i2);
		JLabel lblimage = new JLabel(image);
		lblimage.setBounds(600, 0, 300, 300);
		add(lblimage);

		setSize(1000, 450);
		setLocation(300, 150);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		String pnr = tfpnr.getText();

		try {
			Connect c = new Connect();

			String query = "select * from reservation where PNR = '" + pnr + "'";

			ResultSet rs = c.stmt.executeQuery(query);

			if (rs.next()) {
				tfname.setText(rs.getString("name"));
				tfnationality.setText(rs.getString("nationality"));
				lblsrc.setText(rs.getString("source"));
				lbldest.setText(rs.getString("destination"));
				labelfname.setText(rs.getString("flight_name"));
				labelfcode.setText(rs.getString("flight_code"));
				labeldate.setText(rs.getString("date"));
			} else {
				JOptionPane.showMessageDialog(null, "Please enter correct PNR");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Boarding_pass();
	}
}
