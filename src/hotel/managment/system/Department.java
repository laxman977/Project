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

public class Department extends JFrame implements ActionListener{
	JTable table;
	JButton back ,rooms;
	Department() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/HOTEL.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(500, 0, 600, 600);
		add(image);
		
		JLabel li = new JLabel("DEPARTMENT");
		li.setBounds(120,10,100,20);
		add(li);
		
		JLabel l2 = new JLabel("BUDGET");
		l2.setBounds(370,10,100,20);
		add(l2);
		
		

		
		table = new JTable();
		table.setBounds(0,40,500,400);
		add(table);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from department");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//FOR BUTTON
		back = new JButton("BACK");
		back.setBackground(Color.BLACK);
		back.addActionListener(this);
		back.setForeground(Color.WHITE);
		back.setBounds(280,480,150,35);
		add(back);
		

		
		
		setBounds(300, 200, 1050, 600);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
	
		setVisible(false);
		new Reception();
		
	}
	

	public static void main(String[] args) {
		new Department();

	}

}
