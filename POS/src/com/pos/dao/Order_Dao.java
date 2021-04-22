package com.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pos.connection.EstablishConnection;
import com.pos.model.Order;

public class Order_Dao {

	Connection con;

	public ArrayList<Order> getOrder() throws SQLException {
		con = EstablishConnection.getConnection();
		PreparedStatement ps = null;
		String sql = "select * from pos_tbl_order"; // where orderId=?";
		ps = con.prepareStatement(sql);
		// ps.setString(1, orderId);
		ResultSet rs = ps.executeQuery();
		ArrayList<Order> orderList = new ArrayList<Order>();

		while (rs.next()) {
			Order o = new Order();
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
			orderList.add(o);
		}
		return orderList;
	}

	/*
	 * public boolean addOrder(Order o) throws SQLException { con =
	 * EstablishConnection.getConnection(); PreparedStatement ps = null; String sql
	 * =
	 * "insert into pos_tbl_order(orderId,userid,orderDate,storeId,totalPrice,orderStatus,"
	 * +
	 * "cartid,street,city,state,pincode,mobileNo) values(?, ?, ?, ?, ?, ?,?,?,?,?,?,?);"
	 * ;
	 * 
	 * ps = con.prepareStatement(sql);
	 * 
	 * ps.setString(1, o.getOrderId()); ps.setString(2, o.getUserId());
	 * ps.setDate(3, o.getOrderDate()); ps.setString(4, o.getStoreId());
	 * ps.setInt(5, o.getTotalPrice()); ps.setString(6, o.getOrderStatus());
	 * ps.setInt(6, o.getCartId()); ps.setString(1, o.getStreet()); ps.setString(2,
	 * o.getCity()); ps.setString(3, o.getState()); ps.setString(4, o.getPincode());
	 * ps.setString(5, o.getMobileNo());
	 * 
	 * 
	 * if(ps.executeUpdate()>0) return true;
	 * 
	 * return false;
	 * 
	 * }
	 */

	public boolean deleteOrder(String orderId) throws SQLException {
		con = EstablishConnection.getConnection();
		PreparedStatement ps = null;

		String sql = "delete from pos_tbl_order where orderId = ?";

		ps = con.prepareStatement(sql);
		ps.setString(1, orderId);

		if (ps.executeUpdate() > 0)
			return true;

		return false;
	}

}
