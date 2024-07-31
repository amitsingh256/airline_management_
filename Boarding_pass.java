package AirLine_Management;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Boarding_pass extends JFrame implements ActionListener {

	JTextField tfmobile;
	JLabel tfname, tfpnr,tfticket, tfsrc, tfdest, labelfname, labelfcode, labeldate;
	JButton fetchButton,flight;

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

		JLabel lblmobile = new JLabel("MOBILE NO.: ");
		lblmobile.setBounds(60, 100, 150, 25);
		lblmobile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblmobile);

		tfmobile = new JTextField();
		tfmobile.setBounds(180, 100, 200, 25);
		add(tfmobile);

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
		

		JLabel lblticket = new JLabel("TICKET NO. :");
		lblticket.setBounds(60, 180, 150, 25);
		lblticket.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblticket);

		tfticket = new JLabel();
		tfticket.setBounds(220, 180, 150, 25);
		add(tfticket);

		JLabel lblpnr = new JLabel("PNR NO. :");
		lblpnr.setBounds(60, 220, 150, 25);
		lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblpnr);

		tfpnr = new JLabel();
		tfpnr.setBounds(220, 220, 150, 25);
		add(tfpnr);

		JLabel lblsrc = new JLabel("SOURCE :");
		lblsrc.setBounds(60, 260, 150, 25);
		lblsrc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblsrc);

		tfsrc = new JLabel();
		tfsrc.setBounds(220, 260, 150, 25);
		add(tfsrc);

		JLabel lbldest = new JLabel("DEST. :");
		lbldest.setBounds(380, 260, 150, 25);
		lbldest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lbldest);

		tfdest = new JLabel();
		tfdest.setBounds(540, 260, 150, 25);
		add(tfdest);

		JLabel lblfname = new JLabel("Flight Name :");
		lblfname.setBounds(60, 300, 150, 25);
		lblfname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblfname);

		labelfname = new JLabel();
		labelfname.setBounds(220, 300, 150, 25);
		add(labelfname);

		JLabel lblfcode = new JLabel("Flight Code :");
		lblfcode.setBounds(380, 300, 150, 25);
		lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblfcode);

		labelfcode = new JLabel();
		labelfcode.setBounds(540, 300, 150, 25);
		add(labelfcode);

		JLabel lbldate = new JLabel("Date :");
		lbldate.setBounds(60, 340, 150, 25);
		lbldate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lbldate);

		labeldate = new JLabel();
		labeldate.setBounds(220, 340, 150, 25);
		add(labeldate);
		
		  flight = new JButton("PRINT");
	        flight.setBackground(Color.GRAY);
	        flight.setForeground(Color.GREEN);
	        flight.setBounds(400, 380, 120, 25);
	        flight.addActionListener(this);
	        add(flight);

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
		String mobile = tfmobile.getText();

		try {
			Connect c = new Connect();

			String query = "select * from reservation where mobile = '" + mobile + "'";

			ResultSet rs = c.stmt.executeQuery(query);

				if (rs.next()) {
	                tfname.setText(rs.getString("name"));
	                tfticket.setText(rs.getString("ticket_no"));
	                tfpnr.setText(rs.getString("pnr"));
	                labelfname.setText(rs.getString("flight_name"));
	                labelfcode.setText(rs.getString("flight_code"));
	                tfsrc.setText(rs.getString("source"));
	                tfdest.setText(rs.getString("destination"));
	                labeldate.setText(rs.getString("date"));
			} else {
				JOptionPane.showMessageDialog(null, "Please enter correct mobile no.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  if (ae.getSource() == flight)  {
			new Ticket();
			}
		
	} 
	public static void main(String[] args) {
		new Boarding_pass();
	}
}
