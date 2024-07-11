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

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AirLine_Management/icons/home.jpg.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(0, 0, 1600, 800);
		add(image);

		JLabel heading = new JLabel("INDIAN AIRLINES");
		heading.setBounds(450, 200, 800, 200);
		heading.setFont(new Font("tahoma", Font.BOLD, 72));
		heading.setForeground(color);
		image.add(heading);

//=========>>>>>>>>           ADD MENU         <<<<<<<<<<======================
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		JMenu details = new JMenu("Details");
		menubar.add(details);
//============>>>>>>>     ITEM ADD ON MENU      <<<<<<<<<<========================
		JMenuItem flight_details = new JMenuItem("Flight Details");
		flight_details.addActionListener(this);
		details.add(flight_details);
		

		JMenuItem check_pnr_status = new JMenuItem("PNR Status");
		details.add(check_pnr_status);

		JMenuItem book_ticket = new JMenuItem("Book Ticket");
		book_ticket.addActionListener(this);
		details.add(book_ticket);

		JMenuItem cancel = new JMenuItem("Cancel Ticket");
		details.add(cancel);

		JMenuItem customer = new JMenuItem("Customer Details");
		details.add(customer);

		JMenu my_booking = new JMenu("My Booking");
		menubar.add(my_booking);
		JMenuItem boarding_pass = new JMenuItem("Boarding Pass");
		my_booking.add(boarding_pass);

		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		String text = ae.getActionCommand();
		if (text.equals("Flight Details")) {
			new FlightInfo();
		setVisible(false);
		} else if (text.equals("Book Ticket")) {
			new Add_Customer();
			setVisible(false);
		}

	}

	public static void main(String[] args) {
		new Home();

	}

}
