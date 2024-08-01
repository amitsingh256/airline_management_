package AirLine_Management;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ticket extends JFrame implements ActionListener{
	JButton submit;
	public Ticket() {
		setLayout(null);
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("AirLine_Management/icons/airindia.png"));
		JLabel image= new JLabel(i1);
		image.setBounds(0,0,1000,450);
		add(image);
		
		JLabel heading = new JLabel("Thankyou !! your Ticket has been sent to your Registered E-mail.");
		heading.setBounds(135,200,1000,200);
		heading.setFont(new Font("tahoma", Font.ITALIC,24));
		heading.setForeground(Color.RED);
	    image.add(heading);
	    submit = new JButton("Home");
		submit.setBounds(450, 380, 80, 20);
		submit.addActionListener(this);
		image.add(submit);
		setSize(1000, 450);
		setLocation(400, 150);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == submit) {
			new Home();
			setVisible(false);	
		}
	}
	
public static void main(String[] args) {
	new Ticket();
}
}
