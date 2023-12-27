package hotel.managment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame implements ActionListener{
	JTable table;
	JButton back ,submit;
	JComboBox bedType;
	JCheckBox available;
	SearchRoom() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel text = new JLabel("Search for Room");
		text.setFont(new Font("Tahoma",Font.PLAIN,20));
		text.setBounds(400,30,200,30);
		add(text);
		
		JLabel lblbed = new JLabel("Bed Type");
		lblbed.setBounds(50,100,100,20);
		add(lblbed);
		
		bedType = new JComboBox(new String[] {"single Bed","Double Bed","Large Bed"});
		bedType.setBounds(150,100,150,25);
		bedType.setBackground(Color.WHITE);
		add(bedType);
		
		available = new JCheckBox("Only display Avalible"); 
		available.setBounds(650,100,150,25);
		available.setBackground(Color.WHITE);
		add(available);
		
		JLabel li = new JLabel("Room Number");
		li.setBounds(50,160,100,20);
		add(li);
		
		JLabel l2 = new JLabel("Avaailibility");
		l2.setBounds(270,160,100,20);
		add(l2);
		
		JLabel l3 = new JLabel("Status");
		l3.setBounds(450,160,100,20);
		add(l3);
		
		JLabel l4 = new JLabel("Price");
		l4.setBounds(670,160,100,20);
		add(l4);
		
		JLabel l5 = new JLabel("Bed Type");
		l5.setBounds(870,160,100,20);
		add(l5);

		
		table = new JTable();
		table.setBounds(0,200,1000,300);
		add(table);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from room");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.addActionListener(this);
		back.setForeground(Color.WHITE);
		back.setBounds(500,520,120,30);
		add(back);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.addActionListener(this);
		submit.setForeground(Color.WHITE);
		submit.setBounds(300,520,120,30);
		add(submit);
		
		
		setBounds(300, 200, 1000, 600);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==submit) {
			try {
				String query2 = "select * from room where bed_type='"+bedType.getSelectedItem()+"'";
				String query3 ="select * from room where availability='Available' And bed_type='"+bedType.getSelectedItem()+"'";
			   
				Conn conn = new Conn();
				ResultSet rs;
			    if(available.isSelected()) {
			    	rs = conn.s.executeQuery(query3);
			    }else {
			    	rs = conn.s.executeQuery(query2);
			    }
			    table.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
		setVisible(false);
		new Reception();
		}
	}
	

	public static void main(String[] args) {
		new SearchRoom();

	}

}
