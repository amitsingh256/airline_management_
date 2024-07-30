package AirLine_Management;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class Journey_Details extends JFrame implements ActionListener{
    JTable table;
    JTextField pnr;
    JButton show ,reset;
    
    public Journey_Details() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblpnr = new JLabel("ENTER PNR :");
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpnr.setBounds(350, 100, 100, 35);
        add(lblpnr);
        
        pnr = new JTextField();
        pnr.setBounds(450, 100, 210, 35);
        add(pnr);
        
        show = new JButton("Show Details");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(680, 105, 110, 25);
        show.addActionListener(this);
        add(show);
        
        reset = new JButton("RESET");
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        reset.setBounds(800, 105, 110, 25);
        reset.addActionListener(this);
        add(reset);
        
        table = new JTable();
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 200, 1200, 600);
        jsp.setBackground(Color.WHITE);
        add(jsp);
        
        setSize(1200, 700);
        setLocation(200, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == show) {
    	try {
            Connect c = new Connect();
            ResultSet rs = c.stmt.executeQuery("select * from reservation where PNR = '"+pnr.getText()+"'");
            
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "No Information Found");
                return;
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
    	} catch(Exception e) {
            e.printStackTrace();
        }
    } else if (ae.getSource() == reset) {
        	pnr.setText(" ");
		}
		}	
        
   public static void main(String[] args) {
        new Journey_Details();
    }
}


