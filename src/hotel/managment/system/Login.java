package hotel.managment.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

	JTextField username;
	JPasswordField password; // for password hide like dot dot
	JButton login, cancel;

	Login() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		// username
		JLabel user = new JLabel("Username");
		user.setBounds(40, 20, 100, 30);
		add(user);

		// Textfields for username
		username = new JTextField();
		username.setBounds(150, 20, 150, 30);
		add(username);

		// password
		JLabel pass = new JLabel("password");
		pass.setBounds(40, 70, 100, 30);
		add(pass);

		// TextFields for password
		password = new JPasswordField();
		password.setBounds(150, 70, 150, 30);
		add(password);

		// for login Button
		login = new JButton("Login");
		login.setBounds(40, 150, 120, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);

		// for cancel Button
		cancel = new JButton("Cancel");
		cancel.setBounds(180, 150, 120, 30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		add(cancel);

		// for image
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/UserFace2.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);// for crop the immage
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 10, 200, 200);
		add(image);

		setBounds(500, 200, 600, 300);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == login) {
			String user = username.getText();
			@SuppressWarnings("deprecation")
			String pass = password.getText();
			try {
				Conn c = new Conn();

				String query = "select * from login where Username = '" + user + "' and password  = '" + pass + "'";
				ResultSet rs = c.s.executeQuery(query);
				if (rs.next()) {
					new Dashboard();
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Username or password");
					setVisible(false);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (ae.getSource() == cancel) {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		new Login();
	}
}
