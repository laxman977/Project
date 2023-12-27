package hotel.managment.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddCustomer extends JFrame implements ActionListener {
	JComboBox comboid;
	JTextField tfnumber, tfname, tfcountry, tfdeposite;
	JRadioButton rmale, rfemale;
	JLabel checkintime;
	Choice croom;
	JButton Add, back;

	AddCustomer() {

		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel text = new JLabel("NEW CUSTOMER FORM");
		text.setBounds(100, 20, 300, 30);
		text.setFont(new Font("Raleway", Font.BOLD, 20));
		add(text);

		JLabel lblid = new JLabel("ID");
		lblid.setBounds(35, 80, 100, 20);
		lblid.setFont(new Font("Raleway", Font.PLAIN, 20));
		add(lblid);

		String options[] = { "Aadhar Card", "Passport", "Driving License", "Voter-Id Card", "Ration Card" };
		comboid = new JComboBox(options);
		comboid.setBounds(200, 80, 150, 25);
		comboid.setBackground(Color.WHITE);
		add(comboid);

		// FOR NUMBER
		JLabel lblnumber = new JLabel("Number");
		lblnumber.setBounds(35, 120, 100, 20);
		lblnumber.setFont(new Font("Raleway", Font.PLAIN, 20));
		add(lblnumber);
		tfnumber = new JTextField();
		tfnumber.setBounds(200, 120, 150, 25);
		add(tfnumber);
		setVisible(true);

		// FOR NAME
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(35, 160, 100, 20);
		lblname.setFont(new Font("Raleway", Font.PLAIN, 20));
		add(lblname);
		tfname = new JTextField();
		tfname.setBounds(200, 160, 150, 25);
		add(tfname);
		setVisible(true);

		// GENDER
		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(35, 200, 100, 20);
		lblgender.setFont(new Font("Raleway", Font.PLAIN, 20));
		add(lblgender);
		// FOR MALE RADIOBUTTON
		rmale = new JRadioButton("Male");
		rmale.setBackground(Color.WHITE);
		rmale.setBounds(200, 200, 60, 25);
		add(rmale);
		// FOR FEMALE RADIOBUTTON
		rfemale = new JRadioButton("Female");
		rfemale.setBackground(Color.WHITE);
		rfemale.setBounds(270, 200, 100, 25);
		add(rfemale);

		// FOR COUNTRY
		JLabel lblcountry = new JLabel("Country");
		lblcountry.setBounds(35, 240, 100, 20);
		lblcountry.setFont(new Font("Raleway", Font.PLAIN, 20));
		add(lblcountry);
		tfcountry = new JTextField();
		tfcountry.setBounds(200, 240, 150, 25);
		add(tfcountry);
		setVisible(true);

		// FOR ROOM
		JLabel lblroom = new JLabel("Room Number");
		lblroom.setBounds(35, 280, 150, 20);
		lblroom.setFont(new Font("Raleway", Font.PLAIN, 20));
		add(lblroom);
		tfcountry = new JTextField();
		tfcountry.setBounds(200, 240, 150, 25);
		add(tfcountry);
		setVisible(true);

		croom = new Choice();

		try {

			Conn conn = new Conn();
			String query = "select * from room where availability = 'Available'";
			ResultSet rs = conn.s.executeQuery(query);
			while (rs.next()) {
				croom.add(rs.getString("roomnumber"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		croom.setBounds(200, 280, 150, 25);
		add(croom);

		JLabel lbltime = new JLabel("Checking time");
		lbltime.setBounds(35, 320, 150, 20);
		lbltime.setFont(new Font("Raleway", Font.PLAIN, 20));
		add(lbltime);

		Date date = new Date();

		// 1+2+3+4+5+"Code from Interview"+1+@+3+4+5

		checkintime = new JLabel("" + date);
		checkintime.setBounds(200, 320, 150, 25);
		checkintime.setFont(new Font("Raleway", Font.PLAIN, 16));
		add(checkintime);

		// FOR DIPOSITE
		JLabel lbldeposit = new JLabel("Deposite");
		lbldeposit.setBounds(35, 360, 100, 20);
		lbldeposit.setFont(new Font("Raleway", Font.PLAIN, 20));
		add(lbldeposit);
		tfdeposite = new JTextField();
		tfdeposite.setBounds(200, 360, 150, 25);
		add(tfdeposite);

		// FOR BUTTON ADD
		Add = new JButton("ADD");
		Add.setBackground(Color.BLACK);
		Add.setForeground(Color.WHITE);
		Add.setBounds(50, 410, 120, 30);
		Add.addActionListener(this);
		add(Add);
		// FOR BUTTON BACK
		back = new JButton("BACK");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(200, 410, 120, 30);
		back.addActionListener(this);
		add(back);

		// FOR IMAGE
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/AddCustomer.jpg"));
		Image i2 = i1.getImage().getScaledInstance(450, 410, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400, 50, 400, 400);
		add(image);

		setBounds(350, 200, 800, 550);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource() == Add) {
				
			String id = (String) comboid.getSelectedItem();
			String number = tfnumber.getText();
			String name = tfname.getText();

			String gender = null;
			if (rmale.isSelected()) {
				gender = "Male";
			} else {
				gender = "Female";
			}

			String country = tfcountry.getText();
			String room = croom.getSelectedItem();
			String time = checkintime.getText();
			String deposit = tfdeposite.getText();
		  try {
				String q1 = "insert into customer values('" + id + "','" + number + "','" + name + "', '" + gender+ "','" + country + "','" + room + "','" + time + "','" + deposit + "')";
				
				
				String q2 = "update room set availability ='Occupied' where roomnumber= '" + room + "'";
			

				Conn conn = new Conn();
				conn.s.executeUpdate(q1);
				conn.s.executeUpdate(q2);
				JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
				setVisible(false);
				new Reception();
			} catch (Exception e) {

			}

		} else if (ae.getSource() == back) {
			setVisible(false);
			new Reception();
		}
	}

	public static void main(String[] args) {
		new AddCustomer();

	}

}
