package AirLine_Management;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.time.LocalDateTime;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

public class Add_Passenger extends JFrame implements ActionListener{
	 JTextField tfname,tfnationality,tfpassport,tfemail,tfmobile;
	 JRadioButton jrmale,jrfemale,jrother;
	
	public Add_Passenger() {
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("AirLine_Management/icons/ticket.jpg"));
		JLabel image= new JLabel(i1);
		image.setBounds(0,0,900,600);
		add(image);
		setLayout(null);
//===========>>>>>>>>> HEADING   <<<<<<<<<<<<=========================
		Label heading = new Label("AIR INDIA");
		heading.setFont(new Font("tahoma", Font.ITALIC, 16));
		heading.setBounds(0,0,100,30);
		heading.setForeground(Color.gray);
		image.add(heading);
		
		Label heading1 = new Label("Add Passsenger Details");
		heading1.setFont(new Font("tahoma", Font.BOLD, 30));
		heading1.setBounds(250,20,350,50);
		heading1.setForeground(Color.black);
		image.add(heading1);
		
//===========>>>>>>>>>     PASSENGER NAME      <<<<<<<<<<<<=========================
		JLabel lblname = new JLabel("Name of Passenger :");
		lblname .setFont(new Font("tahoma", Font.PLAIN, 20));
		lblname .setBounds(30,110,200,30);
		
		image.add(lblname );
		 tfname= new JTextField();
		tfname.setFont(new Font("tahoma", Font.PLAIN, 18));
		tfname.setBounds(220,110,300,30);
		image.add(tfname);
		
//===========>>>>>>>>>     NATIONALITY      <<<<<<<<<<<<=========================
		JLabel lblnationality = new JLabel("Nationality :");
		lblnationality.setFont(new Font("tahoma", Font.PLAIN, 20));
		lblnationality.setBounds(110,138,220,50);
		image.add(lblnationality );
		 tfnationality= new JTextField();
		tfnationality.setFont(new Font("tahoma", Font.PLAIN, 18));
		tfnationality.setBounds(220,150,300,30);
		image.add(tfnationality);
		
//===========>>>>>>>>>        AADHAR NUMBER      <<<<<<<<<<<<=====================
		JLabel lblaadhar = new JLabel("Aadhar No. :");
		lblaadhar.setFont(new Font("tahoma", Font.PLAIN, 20));
		lblaadhar.setBounds(100,180,220,50);
		image.add(lblaadhar);
		tfpassport= new JTextField();
		tfpassport.setFont(new Font("tahoma", Font.PLAIN, 18));
		tfpassport.setBounds(220,190,300,30);
		image.add(tfpassport);
		
//===========>>>>>>>>>    GENDER    <<<<<<<<<<<<=========================
		ButtonGroup gender= new ButtonGroup();
		JLabel lblgender = new JLabel("Gender :");
		lblgender.setFont(new Font("tahoma", Font.PLAIN, 20));
		lblgender.setBounds(135,240,220,50);
		image.add(lblgender);
		jrmale= new JRadioButton("Male");
		jrmale.setBounds(220,250,70,30);
		jrmale.setBackground(Color.WHITE);
		jrmale.setFont(new Font("tahoma", Font.PLAIN, 20));
		image.add(jrmale);
		
	    jrfemale= new JRadioButton("Female");
		jrfemale.setBounds(320,250,100,30);
		jrfemale.setBackground(Color.WHITE);
		jrfemale.setFont(new Font("tahoma", Font.PLAIN, 20));
		image.add(jrfemale);
	   
		jrother= new JRadioButton("Other");
		jrother.setBounds(450,250,80,30);
		jrother.setBackground(Color.WHITE);
		jrother.setFont(new Font("tahoma", Font.PLAIN, 20));
		image.add(jrother);
		gender.add(jrother);
		gender.add(jrfemale);
		gender.add(jrmale);
		

		
//==============>>>>>>>>  E-Mail && CONTACT   <<<<<<<<<<<================
		JLabel lblemail = new JLabel("E-mail :");
		lblemail.setFont(new Font("tahoma", Font.PLAIN, 20));
		lblemail.setBounds(10,330,100,30);
		image.add(lblemail );
	     tfemail= new JTextField();
		tfemail.setFont(new Font("tahoma", Font.PLAIN, 18));
		tfemail.setBounds(85,330,300,30);
		image.add(tfemail);
		
		JLabel lblmobile = new JLabel("Mobile :");
		lblmobile.setFont(new Font("tahoma", Font.PLAIN, 20));
		lblmobile.setBounds(450,330,150,30);
		image.add(lblmobile );
		tfmobile= new JTextField();
		tfmobile.setFont(new Font("tahoma", Font.PLAIN, 18));
		tfmobile.setBounds(550,330,200,30);
		image.add(tfmobile);
		
	 JButton submit = new JButton("SUBMIT");
	 submit.setFont(new Font("tahoma", Font.ITALIC, 24));
	 submit.setBackground(Color.GREEN);
	 submit.setForeground(Color.white);
	 submit.setBounds(320,450,180,50);
	 submit.addActionListener(this);
	 image.add(submit);
	 
		setSize(900,600);
		setLocation(300,150);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
			String name= tfname.getText();
			String nationality = tfnationality.getText();
			String aadhar= tfpassport.getText();
			String email=tfemail.getText();
			String mobile= tfmobile.getText();
			String gender= null;
			if (jrmale.isSelected()) {
				gender= "male";
			}else if (jrfemale.isSelected()) {
				gender="female";
			}else if (jrother.isSelected()) {
				gender ="other";
			}
			try {
				Connect c = new Connect();
				String query= "INSERT INTO PASSENGER_DETAILS VALUES('"+name+"','"+nationality+"','"+aadhar+"','"+gender+"','"+email+"','"+mobile+"')";
		       
				c.stmt.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Data saved Successfully");
				new Book_flight();
				setVisible(false);
			
			} catch (Exception e) {
			System.out.println("invailid data");
		}
	}
	
public static void main(String[] args) {
	new Add_Passenger();
}
}
