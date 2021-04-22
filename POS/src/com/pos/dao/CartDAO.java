package com.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Timestamp;

import com.pos.connection.EstablishConnection;
import com.pos.model.Cart;


public class CartDAO {

	Connection con;

	public ArrayList<Cart> getCart() throws SQLException
	{
		con = EstablishConnection.getConnection();
		PreparedStatement ps = null;
		String sql = "select * from pos_tbl_cart;";
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
	
	
	ArrayList<Cart> cart = new ArrayList<Cart>();
	
	while(rs.next())
	{
		Cart c = new Cart();
		c.setCartId(rs.getInt("cartId"));
		c.setUserId(rs.getString("userId"));
		c.setFoodId(rs.getString("foodId"));
		c.setType(rs.getString("type"));
		c.setQuantity(rs.getInt("quantity"));
		c.setCost(rs.getInt("cost"));
		c.setOrderDate(rs.getTimestamp("orderDate"));
		
		cart.add(c);
	}
	return cart;
}
}
