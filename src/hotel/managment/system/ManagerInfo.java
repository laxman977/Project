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
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class ManagerInfo extends JFrame implements ActionListener{
	JTable table;
	JButton back ,rooms;
	ManagerInfo() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Manager.png"));
		Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(650, 0, 600, 600);
		add(image);
		
		JLabel li = new JLabel("Name");
		li.setBounds(30,10,100,20);
		add(li);
		
		JLabel l2 = new JLabel("Age");
		l2.setBounds(120,10,100,20);
		add(l2);
		
		JLabel l3 = new JLabel("Gender");
		l3.setBounds(200,10,100,20);
		add(l3);
		
		JLabel l4 = new JLabel("Job");
		l4.setBounds(290,10,100,20);
		add(l4);
		
		JLabel l5 = new JLabel("Salary");
		l5.setBounds(380,10,100,20);
		add(l5);
		
		JLabel l6 = new JLabel("Mobile No");
		l6.setBounds(470,10,100,20);
		add(l6);
		
		
		JLabel l7 = new JLabel("Gmail");
		l7.setBounds(580,10,100,20);
		add(l7);
		
		
		JLabel l8 = new JLabel("Aadhar");
		l8.setBounds(670,10,100,20);
		add(l8);
		
		

		
		table = new JTable();
		table.setBounds(10,40,750,400);
		add(table);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from employee where job = 'manager'");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//FOR BUTTON
		back = new JButton("BACK");
		back.setBackground(Color.BLACK);
		back.addActionListener(this);
		back.setForeground(Color.WHITE);
		back.setBounds(280,500,150,35);
		add(back);
		

		
		
		setBounds(300, 200, 1150, 600);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
	
		setVisible(false);
		new Reception();
		
	}
	

	public static void main(String[] args) {
		new ManagerInfo();

	}

}
