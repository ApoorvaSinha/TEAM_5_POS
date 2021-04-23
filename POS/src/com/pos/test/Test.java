package com.pos.test;

import java.sql.SQLException;
import java.sql.Timestamp;

import com.pos.dao.AdminDAO;
import com.pos.frames.Login;
import com.pos.frames.PaymentGateway;

public class Test {

	public static void main(String[] args) {
		AdminDAO ad = new AdminDAO();
		try {
//			System.out.println(ad.getAllFoodItems());
//			
//			Food f = new Food();
//			f.setName("test");
//			f.setFoodSize("Large");
//			f.setPrice(9998);
//			f.setQuantity(9);
//			f.setType("Veg");
//			f.setFoodId("te1004");
			
//			System.out.println("-----------------------------------------------------------------------------------------------------------------");
//			System.out.println(ad.addFoodItem(f));
//
//			System.out.println("-----------------------------------------------------------------------------------------------------------------");
//			System.out.println(ad.getAllFoodItems());
			
//			System.out.println("-----------------------------------------------------------------------------------------------------------------");
//			System.out.println(ad.deleteFoodItem("te1003"));

//			System.out.println("-----------------------------------------------------------------------------------------------------------------");
//			System.out.println(ad.getAllFoodItems());
			
//			System.out.println("-----------------------------------------------------------------------------------------------------------------");
//			System.out.println(ad.updateFoodItem(f));
//
//			System.out.println("-----------------------------------------------------------------------------------------------------------------");
//			System.out.println(ad.getAllFoodItems());

//			System.out.println(ad.getAllPizzaStore());
//			PizzaStore p = new PizzaStore();
//			p.setCity("test");
//			p.setMobileNo("6666666661");
//			p.setName("test");
//			p.setPincode("test");
//			p.setState("test");
//			p.setStreet("test");
//			p.setStoreId("te1005");
//			System.out.println("-----------------------------------------------------------------------------------------------------------------");
//			System.out.println(ad.updatePizzaStore(p));
//			System.out.println("-----------------------------------------------------------------------------------------------------------------");
//			System.out.println(ad.getAllPizzaStore());
//			System.out.println(ad.deletePizzaStore("te1004"));
//			System.out.println("-----------------------------------------------------------------------------------------------------------------");
//			System.out.println(ad.getAllPizzaStore());
			// cred number(16 digit),name (name of user),cvv (3 digit) 
			new Login();
//
//			Timestamp t=new Timestamp(System.currentTimeMillis());
//			System.out.println(t);
//			new PaymentGateway();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
