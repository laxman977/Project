package hotel.managment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddDriver extends JFrame implements ActionListener {
	
	JButton add,cancel;
	JTextField tfname,tfcompany,tfage,tfmodel,tflocation;
	JComboBox typecombo,agecombo,avaliablecombo,gendercombo;
	
	AddDriver(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("Add Drivers");
		heading.setFont(new Font("Tahoma",Font.BOLD,18));
		heading.setBounds(150,10,200,20);
		add(heading);
		
		// For Driver Name
		JLabel lblname = new JLabel("Name");
		lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblname.setBounds(60,70,120,30);
		add(lblname);
		tfname = new JTextField();
		tfname.setBounds(200,80,150,30);
		add(tfname);
		 
		//for age
		JLabel lblage = new JLabel("Age");
		lblage.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblage.setBounds(60,110,120,30);
		add(lblage);
		tfage = new JTextField();
		tfage.setBounds(200,110,150,30);
		add(tfage);
		
		//for Driver Gender
		JLabel lblgender = new JLabel("Gender");
		lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblgender.setBounds(60,150,120,30);
		add(lblgender);
		String cleanOption[]= {"Male","Female"};
	    gendercombo = new JComboBox(cleanOption);
	    gendercombo.setBounds(200,150,150,30);
	    gendercombo.setBackground(Color.WHITE);
		add(gendercombo);
		
		//for Car Company
		JLabel lblprice = new JLabel("Car Company");
		lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblprice.setBounds(60,190,120,30);
		add(lblprice);
		tfcompany = new JTextField();
		tfcompany.setBounds(200,190,150,30);
		add(tfcompany);
		
		//Car Model
		JLabel lbltype = new JLabel("Car Model");
		lbltype.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbltype.setBounds(60,230,120,30);
		add(lbltype);
		tfmodel = new JTextField();
		tfmodel.setBounds(200,230,150,30);
		add(tfmodel);
		
		//For Driver Availability
		JLabel lblAvalible = new JLabel("Avalible");
		lblAvalible.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblAvalible.setBounds(60,270,120,30);
		add(lblAvalible);
		String driverOption[]= {"Avalible","Busy"};
	    avaliablecombo = new JComboBox(driverOption);
	    avaliablecombo.setBounds(200,270,150,30);
	    avaliablecombo.setBackground(Color.WHITE);
		add(avaliablecombo);
		
		// Driver Location
		JLabel lbllocation = new JLabel("Location");
		lbllocation.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbllocation.setBounds(60,310,120,30);
		add(lbllocation);
		tflocation = new JTextField();
		tflocation.setBounds(200,310,150,30);
		add(tflocation);
		
		// for Button add
	    add = new JButton("Add Driver");
		add.setForeground(Color.WHITE);
		add.setBackground(Color.BLACK);
		add.setBounds(60,370,130,30);
		add.addActionListener(this);
		add(add);
		//for Button cancel
		cancel = new JButton("cancel");
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.BLACK);
		cancel.setBounds(220,370,130,30);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400,30,500,300);
		add(image);
		
		
		
		setBounds(300,200,980,470);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == add) {
			String name      = tfname.getText();
			String age       = tfage.getText();
			String gender    = (String)gendercombo.getSelectedItem();
			String company   = tfcompany.getText();
			String model     = tfmodel.getText();
			String available =(String) avaliablecombo.getSelectedItem();
			String location  = tflocation.getText();
			
			
			try {
				Conn conn = new Conn();
				String str = "insert into driver values('"+name+"','"+age+"','"+gender+"', '"+company+"','"+model+"','"+available+"','"+location+"')";
				conn.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null,"New Driver Added Sucssfully");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
		}
	}
	public static void main(String[] args) {
		new AddDriver();

	}

}

