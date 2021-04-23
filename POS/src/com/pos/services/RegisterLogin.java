package com.pos.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.pos.connection.EstablishConnection;
import com.pos.model.User;
import com.pos.model.UserCredentials;

public class RegisterLogin implements DbWork {

	@Override
	public boolean register(User user, UserCredentials cred) throws Exception {
		Connection con=EstablishConnection.getConnection();
		
	//	String sql="insert into user(first_name,last_name,DOB,gender,street,location,city,state,zip_code,mobile_no,email_id) values("+
	//				"'"+user.getFirstName()+"','"+user.getLastName()+"',"+user.getDob()+",'"+user.getGender()+"','"+user.getStreet()+"','"+
	//				user.getLocation()+"','"+user.getCity()+"','"+user.getState()+"','"+user.getZipcode()+"','"+user.getMobileNo()+"','"+user.getEmailId()+"')";
		
		
		PreparedStatement ps=null;
		String sql1="INSERT INTO user (`first_name`, `last_name`, `DOB`, `gender`, `street`, `location`, `city`, `state`, `zip_code`, `mobile_no`, `email_id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		ps=con.prepareStatement(sql1);
		ps.setString(1,user.getFirstName());
		ps.setString(2,user.getLastName());
		ps.setDate(3,user.getDob());
		ps.setString(4,String.valueOf(user.getGender()));
		ps.setString(5,user.getStreet());
		ps.setString(6,user.getLocation());
		ps.setString(7,user.getCity());
		ps.setString(8,user.getState());
		ps.setString(9,user.getZipcode());
		ps.setString(10,user.getMobileNo());
		ps.setString(11,user.getEmailId());
		
		ps.execute();
		ps=null;
		String userId=null;
		
			Statement stmt=con.createStatement();
			String sql2="select userid from user where mobile_no='"+user.getMobileNo()+"'";
			ResultSet res=stmt.executeQuery(sql2);
			while(res.next())  {
				 
				userId=res.getString(1);
				}

			
			System.out.println(userId);
		
		
		stmt=null;
		sql1="INSERT INTO user_credentials values('"+userId+"','"+cred.getPassword()+"','"+cred.getUserType()+"',"+0+")";
		stmt=con.createStatement();
		stmt.executeUpdate(sql1);
		
		return true;
		
		
		
	}

	@Override
	public UserCredentials login(UserCredentials cred) {
		// TODO Auto-generated method stub
		ResultSet res=null;
		try
		{
		Connection con=EstablishConnection.getConnection();
		Statement stmt=con.createStatement();
		res=stmt.executeQuery("select * from user_credentials where userid='"+cred.getUserId()+"' and password='"+cred.getPassword()+"'");
		if(res.next())
		{
			System.out.println("Running Login ");
			
			char user_type=res.getString(3).charAt(0);
			cred.setUserType(user_type);
			System.out.println(user_type);
			stmt=null;
			stmt=con.createStatement();
			stmt.executeUpdate("update user_credentials set login_status=1 where userid='"+cred.getUserId()+"'");
			
			
		}
		else
		{
			cred.setUserId(null);
			cred.setPassword(null);
			
		}
		}
		catch(Exception e5)
		{
			e5.printStackTrace();
		}
		return cred;
		
		
	}

}
