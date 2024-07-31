package AirLine_Management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Home extends JFrame implements ActionListener {

	public Home() {
		setLayout(null);
		// ===========>>>>>>>> FRAME SET <<<<<<<<<========================
		Color color = new Color(246, 181, 116);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AirLine_Management/icons/air.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(0, 0, 1600, 800);
		add(image);

		JLabel heading = new JLabel("AIR INDIA");
		heading.setBounds(470, 180, 800, 200);
		heading.setFont(new Font("tahoma", Font.BOLD, 100));
		heading.setForeground(color);
		image.add(heading);

//=========>>>>>>>>           ADD MENU         <<<<<<<<<<======================
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		JMenu details = new JMenu("Details");
		details.setFont(new Font("tahoma", Font.BOLD, 16));
		details.setBounds(10,10,80,20);
		menubar.add(details);
//============>>>>>>>     ITEM ADD ON MENU      <<<<<<<<<<========================
		JMenuItem passenger = new JMenuItem("Add Passenger Details");
		passenger.setFont(new Font("tahoma", Font.PLAIN, 12));
		passenger.setBounds(10,10,80,20);
		passenger.addActionListener(this);
		details.add(passenger);
		
		JMenuItem flight_details = new JMenuItem("Flight Details");
		flight_details.setFont(new Font("tahoma", Font.PLAIN, 12));
		flight_details.setBounds(10,10,80,20);
		flight_details.addActionListener(this);
		details.add(flight_details);
		
		JMenuItem Book_flight = new JMenuItem("Book Ticket");
		Book_flight.setFont(new Font("tahoma", Font.PLAIN, 12));
		Book_flight.setBounds(10,10,80,20);
		Book_flight.addActionListener(this);
		details.add(Book_flight);

		JMenuItem Journey_Details = new JMenuItem("PNR Status");
		Journey_Details.setFont(new Font("tahoma", Font.PLAIN, 12));
		Journey_Details.setBounds(10,10,80,20);
		details.add(Journey_Details);
		Journey_Details.addActionListener(this);

		JMenuItem Cancel_ticket = new JMenuItem("Cancel Ticket");
		Cancel_ticket.setFont(new Font("tahoma", Font.PLAIN, 12));
		Cancel_ticket.setBounds(10,10,80,20);
		Cancel_ticket.addActionListener(this);
	  	details.add(Cancel_ticket);

		

		JMenu my_booking = new JMenu("My Booking");
		menubar.add(my_booking);
		my_booking.setFont(new Font("tahoma", Font.BOLD, 16));
		my_booking.setBounds(90,10,80,20);
		JMenuItem Boarding_pass = new JMenuItem("Boarding Pass");
		Boarding_pass.addActionListener(this);
		my_booking.add(Boarding_pass);

		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		String text = ae.getActionCommand();
		if (text.equals("Flight Details")) {
			new FlightInfo();
			setVisible(false);
		} else if (text.equals("Add Passenger Details")) {
			new Add_Passenger();
			setVisible(false);
		} else if (text.equals("Book Ticket")) {
			new Book_flight();
			setVisible(false);
		} else if (text.equals("Cancel Ticket")) {
			new Cancel_ticket();
			setVisible(false);
		}else if (text.equals("PNR Status")) {
			new Journey_Details();
			setVisible(false);
		}else if (text.equals("Boarding Pass")) {
			new Boarding_pass();
			setVisible(false);
		}

	}

	public static void main(String[] args) {
		new Home();

	}

}
