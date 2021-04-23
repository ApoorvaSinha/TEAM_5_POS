package com.pos.frames;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import com.pos.model.UserCredentials;

public class AdminDashboard implements ActionListener{
	
	JFrame frame;
	JPanel panel;

	JButton manageFood, manageStore, viewOrders, logout;
	public AdminDashboard(UserCredentials user) {
		this.createDashboard();
	}

	public void createDashboard()
	{
		frame = new JFrame("Admin Dashboard");
		panel = new JPanel(new GridLayout(6, 3));
		
		
		JLabel label_welcome = new JLabel("Welcome Admin!", SwingConstants.CENTER);
		JLabel empty = new JLabel("");
		JLabel empty1 = new JLabel("");
		JLabel empty2 = new JLabel("");
		JLabel empty3 = new JLabel("");
		JLabel empty4 = new JLabel("");
		JLabel empty5 = new JLabel("");
		JLabel empty6 = new JLabel("");
		JLabel empty7 = new JLabel("");
		JLabel empty8 = new JLabel("");
		JLabel empty9 = new JLabel("");
		JLabel empty10 = new JLabel("");
		JLabel empty11 = new JLabel("");
		JLabel empty12 = new JLabel("");
		JLabel empty13 = new JLabel("");
		
		
		
		manageFood = new JButton("Manage Products");
		manageFood.addActionListener(this);
		
		manageStore = new JButton("Manage Stores");
		manageStore.addActionListener(this);
		
		viewOrders = new JButton("View Orders");
		viewOrders.addActionListener(this);
		
		logout = new JButton("Log Out");
		logout.addActionListener(this);
		
		panel.add(empty);
		panel.add(label_welcome);
		panel.add(empty1);
		panel.add(empty2);
		panel.add(empty3);
		panel.add(empty4);
		panel.add(manageFood);
		panel.add(empty5);
		panel.add(manageStore);
		panel.add(empty6);
		panel.add(empty7);
		panel.add(empty8);
		panel.add(viewOrders);
		panel.add(empty9);
		panel.add(logout);
		panel.add(empty11);
		panel.add(empty12);
		panel.add(empty13);
		
		frame.add(panel);
		frame.setSize(640,480);    
	    frame.setVisible(true);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
public AdminDashboard() {
	// TODO Auto-generated constructor stub
}
//	public static void main(String[] args) {
//		new AdminDashboard().createDashboard();
//
//	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == manageFood)
		{
			try {
				this.frame.dispose();
				new FoodItems().setFoodItems();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == manageStore)
		{
			try {
				this.frame.dispose();
				new PizzaStoreFrame().setPizzaStore();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == viewOrders)
		{
			try {
				this.frame.dispose();
				new Order_Frame().setOrder();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == logout)
		{
			this.frame.dispose();
			new Login();
		}
		
	}

}
