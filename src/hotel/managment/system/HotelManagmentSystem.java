package hotel.managment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public  class HotelManagmentSystem  extends JFrame implements ActionListener{
	
	HotelManagmentSystem(){
		//for create the box
		setSize(1366,565);
		setLocation(100,100);
		setLayout(null);
		
		// for set the image into box
		ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
		JLabel image = new JLabel(l1);
		image.setBounds(0,0,1366,565); //location x ,location Y, length,breath
		add(image);
		
		// for Text
		JLabel text = new JLabel("HOTEL MANAGMENT SYSTEM");
		text.setBounds(20,430,800,90);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("forte", Font.PLAIN,40));
		image.add(text );
		
		// for button
		JButton next = new JButton("ENTER");
		next.setBounds(1150, 455, 110, 30);
		next.setBackground(Color.YELLOW);
		next.setForeground(Color.BLACK);
		next.addActionListener(this); // for link the another frame
		next.setFont(new Font("Algerian", Font.PLAIN,25));
		image.add(next);
		
		
		// for box visible
		setVisible(true);
		
		//for blinking the text we just put a infaniteLoop
		while(true) {
			text.setVisible(false);
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				e.printStackTrace();
			}
			text.setVisible(true);
			try {
				Thread.sleep(600);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
			
	}
	@Override // from ActionListener
	public void actionPerformed(ActionEvent ae) {
		setVisible(false); // for disable the current frame
		new Login(); // its called login constructor and open the login frame
		
	}

	public static void main(String[] args) {
		new HotelManagmentSystem();

	}

}
