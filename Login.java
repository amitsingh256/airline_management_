package AirLine_Management;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
	JButton submit, reset, close;
	JTextField tfusername;
	JPasswordField tfpassword;

	public Login() {
//===========>>>>>>>>    FRAME SET   <<<<<<<<<========================
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
//==========>>>>>>>>>   USERNAME PASSWORD LABEL SET <<<<<<<<<===============

		JLabel lbusername = new JLabel("USER NAME");
		lbusername.setBounds(120, 20, 100, 20);
		add(lbusername);
		tfusername = new JTextField();
		tfusername.setBounds(230, 20, 200, 20);
		add(tfusername);

		JLabel lbpassword = new JLabel("PASSWORD");
		lbpassword.setBounds(120, 60, 100, 20);
		add(lbpassword);
		tfpassword = new JPasswordField();
		tfpassword.setBounds(230, 60, 200, 20);
		add(tfpassword);

//=============>>>>>>>>>>>      SET BUTTON   <<<<<<<<<<<===================		
		submit = new JButton("SUBMIT");
		submit.setBounds(140, 120, 120, 20);
		submit.addActionListener(this);
		add(submit);

		reset = new JButton("RESET");
		reset.setBounds(300, 120, 120, 20);
		reset.addActionListener(this);
		add(reset);

		close = new JButton("CLOSE");
		close.setBounds(240, 160, 120, 20);
		close.addActionListener(this);
		add(close);

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
					System.out.println("valid");
				} else {
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
