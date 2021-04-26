package com.pos.main;

import java.sql.SQLException;
import java.sql.Timestamp;

import com.pos.dao.AdminDAO;
import com.pos.frames.Login;
import com.pos.frames.PaymentGateway;
// our main application for running the application
public class PizzaMainApp {

	public static void main(String[] args) {
		AdminDAO ad = new AdminDAO();
		try {

			new Login();

		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
