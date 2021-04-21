package com.pos.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EstablishConnection {
	
	Connection con;
	
	public EstablishConnection()
	{
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_team5_schema", "root", "root");
			System.out.println("DB Connected");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new EstablishConnection();
	}
}
