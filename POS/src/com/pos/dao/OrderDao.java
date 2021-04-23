package com.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pos.connection.EstablishConnection;
import com.pos.model.Order;

public class OrderDao {

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

	public boolean addOrder(Order order) throws SQLException {
		con=EstablishConnection.getConnection();
		String sql="INSERT INTO pos_tbl_order \n"
				+ "(userid, orderDate, totalPrice,"
				+ "orderStatus, street, city, state, pincode, mobileNo)"
				+ " VALUES (?, ?,?,?, ?, ?,?, ?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, order.getUserId());
		ps.setTimestamp(2, order.getOrderDate());
		ps.setInt(3,order.getTotalPrice());
		ps.setString(4, order.getOrderStatus());
		ps.setString(5, order.getStreet());
		ps.setString(6, order.getCity());
		ps.setString(7, order.getState());
		ps.setString(8, order.getPincode());
		ps.setString(9, order.getMobileNo());
			
		if(ps.execute())	
			return true;
		
		return false;
	}

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
