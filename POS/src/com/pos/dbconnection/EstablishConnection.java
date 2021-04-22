package com.pos.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class EstablishConnection {

 	
 	static Connection con;

 	public static Connection getConnection() {
 		try {
 			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_team5_schema", "root", "root");
 			System.out.println("DB Connected");
 		} 
 		catch (SQLException e) {
 			e.printStackTrace();
 		}
 		return con;
 	}
 	
}
