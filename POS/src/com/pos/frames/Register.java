/*
 Frame for user registration
 Functionality: - fields for name, dob, city, state, email, password, usertype
*/

package com.pos.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.pos.model.User;
import com.pos.model.UserCredentials;
import com.pos.services.RegisterLogin;

public class Register implements ActionListener{
	
	JFrame f;
	JLabel firstName;
	JTextField firstNametext;
	JLabel lastName;
	JTextField lastNameText;
	
	JLabel dob;
	JDatePickerImpl datePicker;
	
	
	JLabel street;
	JTextField streetText;
	
	
	JLabel city;
	JTextField cityText;
	
	JLabel state;
	JTextField stateText;
	
	JLabel location;
	JTextField locationText;
	
	JLabel zipCode;
	JTextField zipCodeText;
	
	JLabel mobileNo;
	JTextField mobileNoText;
	
	
	JLabel email;
	JTextField emailText;
	
	JLabel password;
	JPasswordField passwordText;
	
	JLabel gender;
	JComboBox genderText;
	
	JLabel userType;
	JComboBox userTypeText;
	
	JButton login;
	JButton register;
	public Register()
	{
		f=new JFrame("Registeration Page");
		JLabel title=new JLabel("Registration Form");
		title.setBounds(130, -90, 120, 250);
		title.setVisible(true);
		f.add(title);
		
		firstName=new JLabel("First Name");
		firstName.setBounds(80,50,100,30);
		firstName.setVisible(true);
		f.add(firstName);
		
		firstNametext=new JTextField();
		firstNametext.setBounds(180, 50, 100, 30);
		firstNametext.setVisible(true);
		f.add(firstNametext);
		
		
		
		lastName=new JLabel("Last Name");
		lastName.setBounds(80,80,100,30);
		lastName.setVisible(true);
		f.add(lastName);
		
		lastNameText=new JTextField();
		lastNameText.setBounds(180, 80, 100, 30);
		lastNameText.setVisible(true);
		f.add(lastNameText);
		
		dob=new JLabel("DOB");
		dob.setBounds(80,110,150,30);
		dob.setVisible(true);
		f.add(dob);
		
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePanel.setVisible(false);
		datePicker = new JDatePickerImpl(datePanel,new Formatter());
		datePicker.setBounds(180, 110, 100, 30);
		f.add(datePicker);
		
		street=new JLabel("Street");
		street.setBounds(80,140,100,30);
		street.setVisible(true);
		f.add(street);
		
		streetText=new JTextField();
		streetText.setBounds(180, 140, 100, 30);
		streetText.setVisible(true);
		f.add(streetText);
		
		
		city=new JLabel("City");
		city.setBounds(80,170,100,30);
		city.setVisible(true);
		f.add(city);
		
		cityText=new JTextField();
		cityText.setBounds(180, 170, 100, 30);
		cityText.setVisible(true);
		f.add(cityText);
		
		
		state=new JLabel("State");
		state.setBounds(80,200,100,30);
		state.setVisible(true);
		f.add(state);
		
		stateText=new JTextField();
		stateText.setBounds(180, 200, 100, 30);
		stateText.setVisible(true);
		f.add(stateText);
		

		location=new JLabel("Location");
		location.setBounds(80,230,100,30);
		location.setVisible(true);
		f.add(location);
		
		locationText=new JTextField();
		locationText.setBounds(180, 230, 100, 30);
		locationText.setVisible(true);
		f.add(locationText);
		
		
		zipCode=new JLabel("ZipCode");
		zipCode.setBounds(80,260,100,30);
		zipCode.setVisible(true);
		f.add(zipCode);
		
		zipCodeText=new JTextField();
		zipCodeText.setBounds(180, 260, 100, 30);
		zipCodeText.setVisible(true);
		f.add(zipCodeText);
		
		mobileNo=new JLabel("MobileNo");
		mobileNo.setBounds(80,290,100,30);
		mobileNo.setVisible(true);
		f.add(mobileNo);
		
		mobileNoText=new JTextField();
		mobileNoText.setBounds(180, 290, 100, 30);
		mobileNoText.setVisible(true);
		f.add(mobileNoText);
		
		
		email=new JLabel("Email");
		email.setBounds(80,320,100,30);
		email.setVisible(true);
		f.add(email);
		
		emailText=new JTextField();
		emailText.setBounds(180, 320, 100, 30);
		emailText.setVisible(true);
		f.add(emailText);
		
		
		password=new JLabel("Password");
		password.setBounds(80,350,100,30);
		password.setVisible(true);
		f.add(password);
		
		passwordText=new JPasswordField();
		passwordText.setBounds(180, 350, 100, 30);
		passwordText.setVisible(true);
		f.add(passwordText);
		
		
		gender=new JLabel("Gender");
		gender.setBounds(80,380,100,30);
		gender.setVisible(true);
		f.add(gender);
		
		String[] gen= {"Male","Female"};
		genderText=new JComboBox(gen);
		genderText.setBounds(180,380,100,30);
		genderText.setVisible(true);
		f.add(genderText);
		
		
		userType=new JLabel("User Type");
		userType.setBounds(80,430,100,30);
		userType.setVisible(true);
		f.add(userType);
		
		String[] users= {"Admin","Customer"};
		userTypeText=new JComboBox(users);
		userTypeText.setBounds(180,430,100,30);
		userTypeText.setVisible(true);
		f.add(userTypeText);
		
		
		
		
		login=new JButton("Existing User");
		login.setBounds(70,600, 130, 30);
		login.setVisible(true);
		login.addActionListener(this);
		f.add(login);
		
		register=new JButton("Register");
		register.setBounds(200,600, 100, 30);
		register.addActionListener(this);
		f.add(register);
		
		 f.setSize(700,700);  
		    f.setLayout(null);  
		    f.setVisible(true);   
		
	}
	
	public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login)
		{
			this.f.dispose();
			new Login();
		}
		if(e.getSource()==register)
		{
			String fname=firstNametext.getText();
			String lname=lastNameText.getText();
			String gender=(String)genderText.getSelectedItem();
			char gen=gender.charAt(0);
			String street=streetText.getText();
			String location=locationText.getText();
			String city=cityText.getText();
			String state=stateText.getText();
			String zip=zipCodeText.getText();
			String mobile=mobileNoText.getText();
			String email=emailText.getText();
			String userType=(String)userTypeText.getSelectedItem();
			char userT=userType.charAt(0);
			
			
			
			int year=datePicker.getModel().getYear();
			int date=datePicker.getModel().getDay();
			int month=datePicker.getModel().getMonth();
			String password=new String(passwordText.getPassword());
			
			String dat=year+"-"+month+"-"+date;
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy/mm/dd"); 
			 Date da=null;
			 da=Date.valueOf(dat);
			
			 System.out.println("Date is: "+da); 
			 
			 if(fname.isEmpty() || lname.isEmpty() || street.isEmpty() || location.isEmpty() || city.isEmpty() || state.isEmpty()) {
				 this.f.dispose();
				JOptionPane.showMessageDialog(f,"Please enter all details");  
				new Login();
			 }
			 
			 else if(zip.length()!=6)
			 {
				this.f.dispose();
				JOptionPane.showMessageDialog(f,"Invalid Zip code");  
				new Login();
			 }
			 else if(mobile.length()!=10)
			 {
				this.f.dispose();
				JOptionPane.showMessageDialog(f,"Invalid Mobile Number");  
				new Login();
			 }
			 else if(!isValid(email))
			 {
				this.f.dispose();
				JOptionPane.showMessageDialog(f,"Invalid email id");  
				new Login();
			 }
			 else {
					User user=new User(fname,lname,da,gen,street,location,city,state,zip,mobile,email);
					UserCredentials usercred=new UserCredentials(userT,password);
					
					RegisterLogin r=new RegisterLogin();
					String userId=null;
					try
					{
						
					userId=r.register(user, usercred);
					}
					catch(Exception e2)
					{
						e2.printStackTrace();
					}
					
					
				
					this.f.dispose();
					JOptionPane.showMessageDialog(f,"Registered Successfully.Your id to login is:"+userId);  
					new Login();
			 }
		}
	}
}
			