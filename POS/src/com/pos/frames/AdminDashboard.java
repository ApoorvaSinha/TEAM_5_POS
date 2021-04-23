package com.pos.frames;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class AdminDashboard implements ActionListener{
	
	JFrame frame;
	JPanel panel;
	JButton manageFood, manageStore;
	
	public void createDashboard()
	{
		frame = new JFrame("Admin Dashboard");
		panel = new JPanel(new GridLayout(4, 3));
		
		
		JLabel label_welcome = new JLabel("Welcome Admin!", SwingConstants.CENTER);
		JLabel empty = new JLabel("");
		JLabel empty1 = new JLabel("");
		JLabel empty2 = new JLabel("");
		JLabel empty3 = new JLabel("");
		JLabel empty4 = new JLabel("");
		JLabel empty5 = new JLabel("");
		JLabel empty6 = new JLabel("");
		
		manageFood = new JButton("Manage Products");
	    manageFood.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		manageFood.addActionListener(this);
		
		manageStore = new JButton("Manage Stores");
		manageStore.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		manageStore.addActionListener(this);
		
		panel.add(empty);
		panel.add(label_welcome);
		panel.add(empty1);
		panel.add(empty2);
		panel.add(empty3);
		panel.add(empty4);
		panel.add(manageFood);
		panel.add(empty5);
		panel.add(manageStore);
		
		frame.add(panel);
		frame.setSize(640,480);    
	    frame.setVisible(true);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new AdminDashboard().createDashboard();

	}

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
		
	}

}
