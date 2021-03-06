package com.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pos.connection.EstablishConnection;
import com.pos.model.Food;
import com.pos.model.PizzaStore;

public class AdminDAO {
	Connection con;
	
	// Fetches all the records from Food table
	public ArrayList<Food> getAllFoodItems() throws SQLException
	{
		con = EstablishConnection.getConnection();
		PreparedStatement ps = null;
		String sql = "select * from pos_tbl_food;";
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Food> foodList = new ArrayList<Food>();
		while(rs.next())
		{
			Food f = new Food();
			f.setFoodId(rs.getString("FoodId"));
			f.setName(rs.getString("name"));
			f.setType(rs.getString("type"));
			f.setFoodSize(rs.getString("FoodSize"));
			f.setQuantity(rs.getInt("Quantity"));
			f.setPrice(rs.getInt("Price"));
			
			foodList.add(f);
		}
		return foodList;
	}
	
	// insert into food table
	public boolean addFoodItem(Food f) throws SQLException
	{
		con = EstablishConnection.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into POS_TBL_Food(name, type, FoodSize, quantity, price) values(?,?,?,?,?);";
		ps = con.prepareStatement(sql);
		
		ps.setString(1, f.getName());
		ps.setString(2, f.getType());
		ps.setString(3, f.getFoodSize());
		ps.setInt(4, f.getQuantity());
		ps.setInt(5, f.getPrice());
		
		if(ps.executeUpdate()>0)
			return true;
		
		return false;
		
	}
	
	// delete from food table
	public boolean deleteFoodItem(String FoodId) throws SQLException
	{
		con = EstablishConnection.getConnection();
		PreparedStatement ps = null;
		
		String sql = "delete from POS_TBL_Food where FoodId = ?";
		
		ps = con.prepareStatement(sql);
		ps.setString(1, FoodId);
		
		if(ps.executeUpdate()>0)
			return true;
		
		return false;
	}
	
	//updates food table data based on foodID
	public boolean updateFoodItem(Food f) throws SQLException
	{
		con = EstablishConnection.getConnection();
		PreparedStatement ps = null;
		
		String sql = "update POS_TBL_Food set name = ?, type = ?, FoodSize = ?, quantity = ?, price = ? where FoodId = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, f.getName());
		ps.setString(2, f.getType());
		ps.setString(3, f.getFoodSize());
		ps.setInt(4, f.getQuantity());
		ps.setInt(5, f.getPrice());
		
		ps.setString(6, f.getFoodId());
		
		if(ps.executeUpdate()>0)
			return true;
		return false;
	}
	
	// retrieves record based on FoodId
	public Food getFoodbyID(String FoodId) throws SQLException
	{
		con = EstablishConnection.getConnection();
		PreparedStatement ps = null;
		String sql = "select * from pos_tbl_food where FoodId = ?;";
		ps = con.prepareStatement(sql);
		ps.setString(1, FoodId);
		
		ResultSet rs = null;
		rs = ps.executeQuery();
		Food f = new Food();
		
		if(rs.next())
		{
			f.setFoodId(FoodId);
			f.setName(rs.getString("name"));
			f.setType(rs.getString("type"));
			f.setFoodSize(rs.getString("FoodSize"));
			f.setQuantity(rs.getInt("Quantity"));
			f.setPrice(rs.getInt("Price"));
		}
		else
			f = null;
		return f;
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	// Fetches all the records from PizzaStore table
	public ArrayList<PizzaStore> getAllPizzaStore() throws SQLException
	{
		con = EstablishConnection.getConnection();
		PreparedStatement ps = null;
		String sql = "select * from pos_tbl_pizzastore;";
		
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<PizzaStore> storeList = new ArrayList<PizzaStore>();
		while(rs.next())
		{
			PizzaStore p = new PizzaStore();
			p.setStoreId(rs.getString("storeId"));
			p.setName(rs.getString("name"));
			p.setStreet(rs.getString("street"));
			p.setMobileNo(rs.getString("mobileNo"));
			p.setCity(rs.getString("city"));
			p.setState(rs.getString("state"));
			p.setPincode(rs.getString("pincode"));
			
			storeList.add(p);
		}
		return storeList;
	}
	
	
	//Insert into PizzaStore table
	public boolean addPizzaStore(PizzaStore p) throws SQLException
	{
		con = EstablishConnection.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into POS_TBL_PizzaStore(name,street,mobileNo,city,state,pincode) values(?, ?, ?, ?, ?, ?);";
		
		ps = con.prepareStatement(sql);
		
		ps.setString(1, p.getName());
		ps.setString(2, p.getStreet());
		ps.setString(3, p.getMobileNo());
		ps.setString(4, p.getCity());
		ps.setString(5, p.getState());
		ps.setString(6, p.getPincode());
		
		if(ps.executeUpdate()>0)
			return true;
		
		return false;
		
	}
	
	// delete from PizzaStore table
	public boolean deletePizzaStore(String storeId) throws SQLException
	{
		con = EstablishConnection.getConnection();
		PreparedStatement ps = null;
		
		String sql = "delete from POS_TBL_PizzaStore where storeId = ?";
		
		ps = con.prepareStatement(sql);
		ps.setString(1, storeId);
		
		if(ps.executeUpdate()>0)
			return true;
		
		return false;
	}
	
	// updates a single record based on storeID of PizzaStore Table
	public boolean updatePizzaStore(PizzaStore p) throws SQLException
	{
		con = EstablishConnection.getConnection();
		PreparedStatement ps = null;
		
		String sql = "update POS_TBL_PizzaStore set name=?,street = ?,mobileNo = ?,city = ?,state = ?,pincode = ? where storeId = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, p.getName());
		ps.setString(2, p.getStreet());
		ps.setString(3, p.getMobileNo());
		ps.setString(4, p.getCity());
		ps.setString(5, p.getState());
		ps.setString(6, p.getPincode());
		
		ps.setString(7, p.getStoreId());
		
		if(ps.executeUpdate()>0)
			return true;
		return false;
	}
	
	// retrieves a single record from Pizza Store table based on
	public PizzaStore getStorebyID(String storeId) throws SQLException
	{
		con = EstablishConnection.getConnection();
		PreparedStatement ps = null;
		String sql = "select * from POS_TBL_PizzaStore where storeId = ?;";
		ps = con.prepareStatement(sql);
		ps.setString(1, storeId);
		
		ResultSet rs = null;
		rs = ps.executeQuery();
		PizzaStore p = new PizzaStore();
		
		if(rs.next())
		{
			p.setStoreId(rs.getString("storeId"));
			p.setName(rs.getString("name"));
			p.setStreet(rs.getString("street"));
			p.setMobileNo(rs.getString("mobileNo"));
			p.setCity(rs.getString("city"));
			p.setState(rs.getString("state"));
			p.setPincode(rs.getString("pincode"));
		}
		else
			p = null;
		return p;
	}
	
	
	
}
