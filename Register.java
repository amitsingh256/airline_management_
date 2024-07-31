package AirLine_Management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register extends JFrame implements ActionListener {
	
	JButton submit, reset, close, login;
	JTextField tfusername;
	JPasswordField tfpassword;
	public Register() {
		setSize(600, 350);
		setLocation(600, 250);
		setVisible(true);
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("AirLine_Management/icons/register.jpg"));
		JLabel image= new JLabel(i1);
		image.setBounds(0,0,600,400);
		add(image);
		setLayout(null);
		
//============>>>>>>>>>>   HEADING <<<<<<<<<===================
		Label heading = new Label("AIR-INDIA Welcomes You!!");
		heading.setFont(new Font("tahoma", Font.ITALIC, 16));
		heading.setBounds(170,10,210,30);
		heading.setForeground(Color.BLACK);
		image.add(heading);

		Label heading1 = new Label("Register Here!");
		heading1.setFont(new Font("tahoma", Font.BOLD, 16));
		heading1.setBounds(10,60,110,30);
		heading1.setForeground(Color.blue);
		image.add(heading1);

		JLabel lbusername = new JLabel("USER NAME :");
		lbusername.setBounds(30,130, 120,30);
		lbusername.setFont(new Font("tahoma", Font.ITALIC, 20));
		lbusername.setForeground(Color.WHITE);
		
    	image.add(lbusername);
		tfusername = new JTextField();
		tfusername.setBounds(155, 130, 250, 30);
		tfusername.setFont(new Font("tahoma", Font.PLAIN, 20));
		image.add(tfusername);

		JLabel lbpassword = new JLabel("PASSWORD :");
		lbpassword.setBounds(30, 170, 120, 30);
		lbpassword.setFont(new Font("tahoma", Font.ITALIC, 20));
		lbpassword.setForeground(Color.WHITE);
		image.add(lbpassword);
		tfpassword = new JPasswordField();
		tfpassword.setBounds(155, 170, 250, 25);
		tfpassword.setFont(new Font("tahoma", Font.PLAIN, 20));
		image.add(tfpassword);

//=============>>>>>>>>>>>      SET BUTTON   <<<<<<<<<<<===================		
		submit = new JButton("SAVE");
		submit.setBounds(140, 250, 120, 20);
		submit.addActionListener(this);
		image.add(submit);

		reset = new JButton("RESET");
		reset.setBounds(300, 250, 120, 20);
		reset.addActionListener(this);
		image.add(reset);
		
	
		Label heading2 = new Label("Already Register go to login page >>>");
		heading2.setFont(new Font("tahoma", Font.BOLD, 10));
		heading2.setBounds(90,303,200,15);
		heading2.setForeground(Color.BLACK);
		image.add(heading2);
		login = new JButton("Login");
		login.setBounds(300, 300, 120, 20);
		login.addActionListener(this);
		image.add(login);
        
		setSize(600, 400);
		setLocation(600, 250);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == submit) {

			String username = tfusername.getText();
			String password = tfpassword.getText();

			try {
				Connect c = new Connect();
				String query= "INSERT INTO LOGIN VALUES('"+username+"','"+password+"')";
		       
				c.stmt.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Data saved Successfully");
				tfusername.setText("");
				tfpassword.setText("");
			    new Login();
			    setVisible(false);
			} catch (Exception e) {
			System.out.println("invailid data");
		}
			
	}	
		 if (ae.getSource() == reset) {
			tfusername.setText("");
			tfpassword.setText("");
		}else if (ae.getSource()==login) {
			new Login();
			setVisible(false);
		} 
	}
	
	
public static void main(String[] args) {
	 new Register();
}
}
