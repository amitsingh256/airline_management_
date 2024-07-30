package AirLine_Management;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.channels.IllegalBlockingModeException;

public class Login extends JFrame implements ActionListener {
	JButton submit, reset, close;
	JTextField tfusername;
	JPasswordField tfpassword;

	public Login() {
		
//===========>>>>>>>>    FRAME SET   <<<<<<<<<========================
//		getContentPane().setBackground(Color.WHITE);
	
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("AirLine_Management/icons/login1.jpeg"));
		JLabel image= new JLabel(i1);
		image.setBounds(0,0,600,350);
		add(image);
		setLayout(null);
		
//============>>>>>>>>>>   HEADING <<<<<<<<<===================
		Label heading = new Label(" LOGIN ");
		heading.setFont(new Font("tahoma", Font.ITALIC, 16));
		heading.setBounds(20,10,70,30);
		heading.setForeground(Color.BLACK);
		image.add(heading);
//==========>>>>>>>>>   USERNAME PASSWORD LABEL SET <<<<<<<<<===============

		JLabel lbusername = new JLabel("USER NAME");
		lbusername.setBounds(70,50, 200,30);
		lbusername.setFont(new Font("tahoma", Font.ITALIC,20));
		lbusername.setForeground(Color.WHITE);
    	image.add(lbusername);
		tfusername = new JTextField();
		tfusername.setBounds(200, 50, 250, 30);
		image.add(tfusername);

		JLabel lbpassword = new JLabel("PASSWORD");
		lbpassword.setBounds(70, 90, 200, 30);
		lbpassword.setFont(new Font("tahoma", Font.ITALIC,20));
	    lbpassword.setForeground(Color.WHITE);
		image.add(lbpassword);
		tfpassword = new JPasswordField();
		tfpassword.setBounds(200, 90, 250, 30);
		image.add(tfpassword);

//=============>>>>>>>>>>>      SET BUTTON   <<<<<<<<<<<===================		
		submit = new JButton("SUBMIT");
		submit.setBounds(140, 200, 120, 20);
		submit.addActionListener(this);
		image.add(submit);

		reset = new JButton("RESET");
		reset.setBounds(300, 200, 120, 20);
		reset.addActionListener(this);
		image.add(reset);

		close = new JButton("CLOSE");
		close.setBounds(240, 260, 120, 20);
		close.addActionListener(this);
		image.add(close);

		setSize(600, 350);
		setLocation(600, 250);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == submit) {

			String username = tfusername.getText();
			String password = tfpassword.getText();
      		try {
				Connect c = new Connect();

			String query = "SELECT * FROM LOGIN WHERE username = '" + username + "' and password = '" + password +"'";
				ResultSet rs = c.stmt.executeQuery(query);
		        if (rs.next()) {
			     new Home();
			     setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Invailid Username OR Password");
					setVisible(false);
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invailid username OR password");
			}
		} else if (ae.getSource() == close) {
			setVisible(false);
		} else if (ae.getSource() == reset) {
			tfusername.setText("");
			tfpassword.setText("");
		}
	}

	public static void main(String[] args) throws NullPointerException {
		new Login();

	}

}

