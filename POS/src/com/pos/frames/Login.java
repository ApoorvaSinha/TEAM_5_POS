/*
 Frame for login
 Functionality: - logs in the user, display pop up for incorrect login
*/

package com.pos.frames;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.pos.model.UserCredentials;
import com.pos.services.RegisterLogin;

public class Login implements ActionListener{
	
	JFrame f;
	JLabel id;
	JTextField nametext;
	JLabel password;
	JPasswordField pass;
	JButton login;
	JButton register;
	public Login()
	{
		f=new JFrame("Login Page");
		JLabel title=new JLabel("Login Form");
		title.setBounds(150, -70, 100, 200);
		title.setVisible(true);
		f.add(title);
		
		id=new JLabel("Id");
		id.setBounds(80,50,100,30);
		id.setVisible(true);
		f.add(id);
		
		nametext=new JTextField();
		nametext.setBounds(180, 50, 100, 30);
		nametext.setVisible(true);
		f.add(nametext);
		
		
		
		password=new JLabel("Password");
		password.setBounds(80,100,100,30);
		password.setVisible(true);
		f.add(password);
		
		pass=new JPasswordField();
		pass.setBounds(180, 100, 100, 30);
		pass.setVisible(true);
		f.add(pass);
		
		login=new JButton("Login");
		login.setBounds(70,150, 100, 30);
		login.setVisible(true);
		login.addActionListener(this);
		f.add(login);
		
		register=new JButton("Register");
		register.setBounds(200,150, 100, 30);
		register.addActionListener(this);
		f.add(register);
		
		 f.setSize(700,700);  
		    f.setLayout(null);  
		    f.setVisible(true);  
		    f.setLocationRelativeTo(null);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==register)
		{
			this.f.dispose();
			new Register();
			
			
		}
		if(e.getSource()==login)
		{
			System.out.println("hello");
			String userId=nametext.getText();
			String pass1=new String(pass.getPassword());
			UserCredentials cred=new UserCredentials(pass1,userId);
			RegisterLogin r=new RegisterLogin();
			UserCredentials credd=r.login(cred);
			if(cred.getUserId()==null)
			{
				this.f.dispose();
				new Login();
				JOptionPane.showMessageDialog(f,"Incorrect Details Please Login Again");  
			}
			else
			{
				
				if(cred.getUserType()=='A') {
					this.f.dispose();
					new AdminDashboard(credd);
				}
				else
				{
					this.f.dispose();
					System.out.print("ASD");
					CustomerDashboard frame = new CustomerDashboard(cred);
					   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					   frame.setTitle("Order your pizza from PizzaLand. Satisfaction guaranteed!");
					   frame.setSize(650, 650);
					   frame.setVisible(true);	
					
				}
			}
				
		}
		
	}
}
