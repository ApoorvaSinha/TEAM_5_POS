package com.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pos.connection.EstablishConnection;
import com.pos.model.User;

public class UserDAO {
Connection con;

public User getData(String userid) throws SQLException
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

}
