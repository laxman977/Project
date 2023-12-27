package hotel.managment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddEmployee extends JFrame implements ActionListener {
 
	JTextField tfname,tfemail,tfphone,tfage,tfsalary,tfaadhar;
	JRadioButton rbmale,rbfemale;
	JButton submit;
	ButtonGroup  bg;
	JComboBox cbjob;
	
	
	AddEmployee(){
	  setLayout(null);
	  
	  // for name label
	  JLabel lblname = new JLabel("NAME");
	  lblname.setBounds(60 ,30,120,30);
	  lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
	  add(lblname);
	   //text field for name
	  tfname= new JTextField();
	  tfname.setBounds(200,30,150,30);
	  add(tfname);
	  
	  
	  // for Age label
	  JLabel lblage = new JLabel("AGE");
	  lblage.setBounds(60 ,80,120,30);
	  lblage.setFont(new Font("Tahoma",Font.PLAIN,17));
	  add(lblage);
	   //text field for Age
	  
	  tfage= new JTextField();
	  tfage.setBounds(200,80,150,30);
	  add(tfage);
	  
	  
	  // for gender 
	  JLabel lblgender = new JLabel("GENDER");
	  lblgender.setBounds(60 ,130,120,30);
	  lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
	  add(lblgender);
	  
	  rbmale = new JRadioButton("Male");
	  rbmale.setBounds(200,130,70,30);
	  rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
	  rbmale.setBackground(Color.WHITE);
	  add(rbmale);
	  
	  rbfemale = new JRadioButton("FeMale");
	  rbfemale.setBounds(280,130,70,30);
	  rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
	  rbfemale.setBackground(Color.WHITE);
	  add(rbfemale);
	  
	  
	  bg = new ButtonGroup();
	  bg.add(rbmale);
	  bg.add(rbfemale);
	  
	  //JOb
	  JLabel lbljob = new JLabel("JOB");
	  lbljob.setBounds(60 ,180,120,30);
	  lbljob.setFont(new Font("Tahoma",Font.PLAIN,17));
	  add(lbljob);  
	  //for job dropdown
	  String str[]= {"Select","Fornt Desk Clerks","Proters","HouseKeeping","Kitchen Staff","Room Service","Chefs","Water/Waiterss","Manager","Accountant"};
	  cbjob = new JComboBox(str);
	  cbjob.setBounds(200,180,150,30);
	  cbjob.setBackground(Color.WHITE);
	  add(cbjob);
	  
	  //for salary
	  JLabel lblsalary = new JLabel("SALARY");
	  lblsalary.setBounds(60 ,230,120,30);
	  lblsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
	  add(lblsalary);
	   //text field for salary
	  tfsalary= new JTextField();
	  tfsalary.setBounds(200,230,150,30);
	  add(tfsalary);
	  
	  
	  //for PHONE number
	  JLabel lblphone = new JLabel("PHONE");
	  lblphone.setBounds(60 , 280,120,30);
	  lblphone.setFont(new Font("Tahoma",Font.PLAIN,17));
	  add(lblphone);
	   //text field for PHoneNumber
	  tfphone= new JTextField();
	  tfphone.setBounds(200,280,150,30);
	  add(tfphone);
	  
	  
	  //for Email
	  JLabel lblemail = new JLabel("Email");
	  lblemail.setBounds(60 , 330,120,30);
	  lblemail.setFont(new Font("Tahoma",Font.PLAIN,17));
	  add(lblemail);
	   //text field for Email
	  tfemail= new JTextField();
	  tfemail.setBounds(200,330,150,30);
	  add(tfemail);
	  
	  
	  //for Aadhar
	  JLabel lblaadhar = new JLabel("AADHAR");
	  lblaadhar.setBounds(60 , 380,120,30);
	  lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
	  add(lblaadhar);
	   //text field for Aadhar
	  tfaadhar = new JTextField();
	  tfaadhar.setBounds(200,380,150,30);
	  add(tfaadhar);
	  
	  
	  
	  // for submit button
	  submit = new JButton("SUBMIT");
	  submit.setBackground(Color.BLACK);
	  submit.setForeground(Color.WHITE);
	  submit.setBounds(200,430,150,30);
	  submit.addActionListener(this);
	  add(submit);
	  
	  
	  //for Image
	  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
	  Image i2 =i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
	  ImageIcon i3 = new ImageIcon(i2);
	  JLabel image=new JLabel(i3);
	  image.setBounds(380,60,450,380);
	  add(image);
	  
	  
	  
	  getContentPane().setBackground(Color.WHITE);
	  setBounds(350,200,850,540);
	  setVisible(true);
  }
  
  public void actionPerformed(ActionEvent ae) {
	  String name = tfname.getText();
	  String age = tfage.getText();
	  String salary = tfsalary.getText();
	  String phone = tfphone.getText();
	  String email = tfemail.getText();
	  String aadhar = tfaadhar.getText();
	  
	  String gender =null;
	  
	  // Validation
	  if(name.equals("")) {
		  JOptionPane.showMessageDialog(null,"Name should not be empty");
		  return;
	  }
	  if(email.equals("") || !email.contains("@") || !email.contains(".com") ) {
		  JOptionPane.showMessageDialog(null,"Email is not valid");
		  return;
	  }
	  if(age.equals("") || !age.contains("0") || !age.contains("-")) {
		  JOptionPane.showMessageDialog(null,"please input valid number");
		  return;
	  }
	  if(salary.equals("") || !salary.contains("0") || !salary.contains("-")) {
		  JOptionPane.showMessageDialog(null,"salary must be in (+) number");
		  return;
	  }
	  if(phone.equals("")  || !phone.contains("-")) {
		  JOptionPane.showMessageDialog(null,"Age is not valid is not valid");
		  return;
	  }
	  
	  
	  if(rbmale.isSelected()) {
		  gender = "Male";
	  }else if(rbfemale.isSelected()){
		  gender = "female";
	  }
	  String job = (String) cbjob.getSelectedItem(); // for get the which item is selected form job
	  
	  try {
		  Conn conn = new Conn();
		  String query="insert into employee value('"+name+"','"+age+"','"+gender+"', '"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
		  conn.s.executeUpdate(query);
		  JOptionPane.showMessageDialog(null,"Employee added successfully");
		  setVisible(false);
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
  
  
  }
  public static void main(String[] args) {
	new AddEmployee();
}
}
