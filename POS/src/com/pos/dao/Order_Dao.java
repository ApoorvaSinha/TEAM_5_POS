package com.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pos.connection.EstablishConnection;
import com.pos.model.Order;

public class Order_Dao {
	
	Connection con; 
	
	public Order getOrder() throws SQLException
	{
		con=EstablishConnection.getConnection();
		PreparedStatement ps=null;
		String sql="select * from pos_tbl_order"; //where orderId=?";
		ps=con.prepareStatement(sql);
		//ps.setString(1, orderId);
		ResultSet rs=ps.executeQuery();
		Order o=new Order();
		
		if(rs.next())
		{
			o.setOrderId(rs.getString("orderId"));
			o.setUserId(rs.getString("userid"));
			o.setOrderDate(rs.getTimestamp("orderDate"));
			o.setStoreId(rs.getString("storeId"));
			o.setTotalPrice(rs.getInt("totalPrice"));
			o.setOrderStatus(rs.getString("orderStatus"));
			o.setCartId(rs.getInt("cartid"));
			o.setStreet(rs.getString("street"));
			o.setCity(rs.getString("city"));
			o.setState(rs.getString("state"));
			o.setPincode(rs.getString("pincode"));
			o.setMobileNo(rs.getString("mobileNo"));
			return o;
		}
		return o;
	}
}
