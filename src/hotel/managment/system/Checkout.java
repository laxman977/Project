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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Checkout extends JFrame implements ActionListener{
	Choice ccustomer;
	JLabel lblroomnumber,lblcheckintime,lblcheckouttime;
	JButton checkout,back;
		Checkout(){
			getContentPane().setBackground(Color.WHITE);
			setLayout(null);
			 
			//FOR HEADING TEXT
			JLabel text = new JLabel("Checkout");
			text.setBounds(100,20,100,30);
			text.setForeground(Color.BLUE);
			text.setFont(new Font("tahoma",Font.BOLD,20));
			add(text);
			
			JLabel lblid = new JLabel("Customer Id");
			lblid.setBounds(30,80,100,30); 
			add(lblid);
			
			ccustomer = new Choice();
			ccustomer.setBounds(150,80,150,25);
			add(ccustomer);
			
			
			// FOR IMAGE
			ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
			Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
			ImageIcon i3 = new ImageIcon(i2);
			JLabel tick = new JLabel(i3);
			tick.setBounds(310, 80, 20, 20);
			add(tick);
			
			// FOR ROOM NUMBER
			JLabel lblroom = new JLabel("Room Number");
			lblroom.setBounds(30,130,100,30); 
			add(lblroom);
			lblroomnumber = new JLabel();
			lblroomnumber.setBounds(150,130,100,30); 
			add(lblroomnumber);
			
			
			//FOR CHECKIN TIME
			JLabel lblcheckin = new JLabel("Checkin time");
			lblcheckin.setBounds(30,180,100,30); 
			add(lblcheckin);		
			lblcheckintime = new JLabel();
			lblcheckintime.setBounds(150,180,100,30); 
			add(lblcheckintime);
			
			
			//FOR CHACK OUT TIME
			JLabel lblcheckout = new JLabel("CheckinOut time");
			lblcheckout.setBounds(30,230,100,30); 
			add(lblcheckout);
			Date date = new Date();
			lblcheckouttime = new JLabel(""+date);
			lblcheckouttime.setBounds(150,230,150,30); 
			add(lblcheckouttime);
			
			
			//FOR CHECKOUT BUTTON
			checkout = new JButton("Checkout");
			checkout.setBackground(Color.BLACK);
			checkout.addActionListener(this);
			checkout.setForeground(Color.WHITE);
			checkout.setBounds(30,280,120,30);
			add(checkout);
			
			
			// FOR BACK BUTTON
			back = new JButton("Back");
			back.setBackground(Color.BLACK);
			back.addActionListener(this);
			back.setForeground(Color.WHITE);
			back.setBounds(170,280,120,30);
			add(back);
			
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery("select * from customer");
			while(rs.next()) {
				ccustomer.add(rs.getString("number"));
				lblroomnumber.setText(rs.getString("room"));
				lblcheckintime.setText(rs.getString("checkintime"));
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
			Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
			ImageIcon i6 = new ImageIcon(i5);
			JLabel image = new JLabel(i6);
			image.setBounds(350, 50, 400, 250);
			add(image);
			
			
			
			setBounds(300,200,800,400);
			setVisible(true);
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()== checkout) {
				String query1 = "select * from customer where number='"+ccustomer.getSelectedItem()+"'";
				String query2 = "update room set avilablity='Available' where roomnumber='"+lblroomnumber.getText()+"'";
			try {
				Conn c = new Conn();
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				JOptionPane.showMessageDialog(null,"checkout done");
				setVisible(false);
				new Reception();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			}else {
				setVisible(false);
				new Reception();
			}
		}
	public static void main(String[] args) {
		new Checkout();

	}

}
