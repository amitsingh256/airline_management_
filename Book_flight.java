package AirLine_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class Book_flight extends JFrame implements ActionListener{
    
    JTextField tfaadhar;
    JLabel tfname, tfnationality, tfmobile,tfemail,tfgender, labelgender, labelfname, labelfcode;
    JButton bookflight, fetchButton, flight;
    Choice source, destination;
    JDateChooser dcdate;
    
   public Book_flight() {
	
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(420,0, 500,60);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 46));
        heading.setForeground(Color.RED);
        add(heading);
        
        JLabel lblaadhar = new JLabel("Aadhar NO.:");
        lblaadhar.setBounds(60, 70, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 70, 150, 25);
        add(tfaadhar);
        
        fetchButton = new JButton("Fetch User");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 70, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblname = new JLabel("Name :");
        lblname.setBounds(60, 110, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        tfname = new JLabel();
        tfname.setBounds(220, 110, 150, 25);
        add(tfname);
        
        JLabel lblnationality = new JLabel("Nationality :");
        lblnationality.setBounds(60, 150, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality); 
        tfnationality = new JLabel();
        tfnationality.setBounds(220, 150, 150, 25);
        add(tfnationality);
        
        JLabel lblmobile = new JLabel("Mobile :");
        lblmobile.setBounds(60, 190, 150, 25);
        lblmobile.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblmobile); 
        tfmobile = new JLabel();
        tfmobile.setBounds(220, 190, 150, 25);
        add(tfmobile);
        
        JLabel lblemail = new JLabel("E-mail :");
        lblemail.setBounds(60, 230, 150, 25);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblemail); 
        tfemail = new JLabel();
        tfemail.setBounds(220, 230, 150, 25);
        add(tfemail );
        
        
        JLabel lblgender = new JLabel("Gender :");
        lblgender.setBounds(60, 270, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        tfgender = new JLabel();
        tfgender.setBounds(220, 270, 150, 25);
        add(tfgender);
        
        JLabel lblsource = new JLabel("Source :");
        lblsource.setBounds(60, 330, 150, 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsource);
        
        source = new Choice();
        source.setBounds(220, 330, 150, 25);       
        add(source);
        
        JLabel lbldest = new JLabel("Destination :");
        lbldest.setBounds(60, 380, 150, 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldest);
        
        destination = new Choice();
        destination.setBounds(220, 380, 150, 25);       
        add(destination);
        
        try {
            Connect c = new Connect();
            String query = "select * from flight_info";
            ResultSet rs = c.stmt.executeQuery(query);
            
            while(rs.next()) {
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        flight = new JButton("Fetch Flights");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(380, 380, 120, 25);
        flight.addActionListener(this);
        add(flight);
        
        JLabel lblfname = new JLabel("Flight Name :");
        lblfname.setBounds(60, 430, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220, 430, 150, 25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code :");
        lblfcode.setBounds(60, 480, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(220, 480, 150, 25);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date of Travel :");
        lbldate.setBounds(60, 530, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(220, 530, 150, 25);
        add(dcdate);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AirLine_Management/icons/Air.logo.png"));
        Image i2 = i1.getImage().getScaledInstance(350, 250, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550, 80, 500, 410);
        add(lblimage);
        
        bookflight = new JButton("Book Flight");
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(220, 580, 150, 25);
        bookflight.addActionListener(this);
        add(bookflight);
        
        setSize(1100, 700);
        setLocation(200, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetchButton) {
            String aadhar = tfaadhar.getText();
            
            try {
                Connect c = new Connect();

                String query = "select * from passenger_details where aadhar_no = '"+aadhar+"'";

                ResultSet rs = c.stmt.executeQuery(query);
                
                if (rs.next()) {
                    tfname.setText(rs.getString("name")); 
                    tfnationality.setText(rs.getString("nationality")); 
                    tfgender.setText(rs.getString("gender"));
                    tfmobile.setText(rs.getString("mobile"));
                    tfemail.setText(rs.getString("E_mail"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct aadhar");                
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == flight) {
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            try {
                Connect c = new Connect();

                String query = "select * from flight_info where source = '"+src+"' and destination = '"+dest+"'";

                ResultSet rs = c.stmt.executeQuery(query);
                
                if (rs.next()) {
                    labelfname.setText(rs.getString("FLIGHT_NAME")); 
                    labelfcode.setText(rs.getString("fLIGHT_CODE")); 
                } else {
                    JOptionPane.showMessageDialog(null, "No Flights Found");                
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Random random = new Random();
            
            String aadhar = tfaadhar.getText();
            String name = tfname.getText(); 
            String nationality = tfnationality.getText();
            String flightname = labelfname.getText(); 
            String flightcode = labelfcode.getText();
            String src = source.getSelectedItem(); 
            String dest = destination.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            
            try {
                Connect c = new Connect();

                String query = "insert into reservation values('PNR"+random.nextInt(1000000000)+"', 'AI-TIC-"+random.nextInt(1000000)+"', '"+aadhar+"', '"+name+"', '"+nationality+"', '"+flightname+"', '"+flightcode+"', '"+src+"', '"+dest+"', '"+date+"')";

                c.stmt.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");

                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Book_flight();
    }
}