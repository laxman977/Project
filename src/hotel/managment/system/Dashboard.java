package hotel.managment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Dashboard extends JFrame implements ActionListener {
	Dashboard() {
		// for frame
		setBounds(0, 0, 1550, 1000);
		setLayout(null);

		// for image
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 1550, 1000);
		add(image);

		// for text
		JLabel text = new JLabel("THE MOHARANA GROUP WELCOMES YOU");
		text.setBounds(400, 80, 1000, 50);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("forte", Font.PLAIN, 40));
		image.add(text);

		// FOR Menu bar
		JMenuBar mb = new JMenuBar();
		mb.setBounds(0, 0, 1550, 30);
		image.add(mb);

		// for hotel management menu bar
		JMenu hotel = new JMenu("HOTEL-MANAGEMENT");
		hotel.setForeground(Color.RED);
		mb.add(hotel);
		// menu Items for Hotel management
		JMenuItem reception = new JMenuItem("RECEPTION");
		reception.addActionListener(this);
		hotel.add(reception);

		// for admin menu bar
		JMenu admin = new JMenu("ADMIN");
		admin.setForeground(Color.BLUE);
		mb.add(admin);
		// menu Items for admin
		JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
		addemployee.addActionListener(this); // LINK TO ADD EMPLOYEE CLASS
		admin.add(addemployee);

		JMenuItem addrooms = new JMenuItem("ADD ROOMS");
		addrooms.addActionListener(this);// LINK TO ADD ROOMS CLASS
		admin.add(addrooms);

		JMenuItem adddriver = new JMenuItem("ADD DRIVERS");
		adddriver.addActionListener(this);
		admin.add(adddriver);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("ADD EMPLOYEE")) {
			new AddEmployee(); // EMPLYOEE CLASS OBJECT
		} else if (ae.getActionCommand().equals("ADD ROOMS")) {
			new AddRooms();
		} else if (ae.getActionCommand().equals("ADD DRIVERS")) {
			new AddDriver();
		} else if (ae.getActionCommand().equals("RECEPTION")) {
			new Reception();
		}
	}

	public static void main(String[] args) {
		new Dashboard();
	}

}
