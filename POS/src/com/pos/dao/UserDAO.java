package com.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pos.connection.EstablishConnection;
import com.pos.model.User;
import com.pos.model.UserCredentials;

public class UserDAO {
Connection con;

public User getUser(String userid) throws SQLException
{
	con=EstablishConnection.getConnection();
	PreparedStatement ps=null;
	String sql="select * from user where userid=?";
	ps=con.prepareStatement(sql);
	ps.setString(1, userid);
	ResultSet rs=ps.executeQuery();
	User u=new User();
	if(rs.next())
	{
		u.setFirstName(rs.getString(2));
		u.setLastName(rs.getString(3));
		u.setDob(rs.getDate(4));
		u.setGender(rs.getString(5).charAt(0));
		u.setStreet(rs.getString(6));
		u.setLocation(rs.getString(7));
		u.setCity(rs.getString(8));
		u.setState(rs.getString(9));
		u.setZipcode(rs.getString(10));
		u.setMobileNo(rs.getString(11));
		u.setEmailId(rs.getString(12));
		u.setUserId(userid);
		return u;
	}
	return null;
}

public boolean setUser(User user,UserCredentials cred) throws SQLException
{
	con=EstablishConnection.getConnection();
	PreparedStatement ps=null;
	
	String sql="INSERT INTO user (`first_name`, `last_name`, `DOB`, `gender`, `street`, `location`, `city`, `state`, `zip_code`, `mobile_no`, `email_id`) VALUES ('?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?')";
	ps=con.prepareStatement(sql);
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
	
	if(ps.execute())
		return true;
	else return false;
	
	// after insertion get the id then insert into user crede.
//	ResultSet rs=ps.executeQuery();
//	User u=new User();
//	return null;
}

}




















 // food frame(admin) + dao ,anubhav 
 // registration dao + frames , yogesh 
 // order frame + dao, apoorva
 // cart karthik
 // customer dashboard Akshat 
 // 







