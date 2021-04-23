package com.pos.frames;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import com.pos.dao.AdminDAO;
import com.pos.model.Food;

public class FoodItems implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton addFood, deleteFood, updateFood, addFoodQuery,deleteFoodQuery,updateFoodQuery, updateFoodQueryFinal, backToDash;
	JTextField text_name,text_type,text_size, text_qty, text_price,text_id;
	AdminDAO ad = new AdminDAO();
	
	public void setFoodItems() throws SQLException
	{   
		frame=new JFrame("Food Items");  
		
		String[][] data;
		
		ArrayList<Food> foodList = ad.getAllFoodItems();
		
		data = new String[foodList.size()][6];
		
		for(int i=0; i<foodList.size(); i++)
		{
			data[i][0] = foodList.get(i).getFoodId();
			data[i][1] = foodList.get(i).getName();
			data[i][2] = foodList.get(i).getType();
			data[i][3] = foodList.get(i).getFoodSize();
			data[i][4] = String.valueOf(foodList.get(i).getQuantity());
			data[i][5] = String.valueOf(foodList.get(i).getPrice());
		}
		

	    String column[]={"FoodId", "Name", "Type", "Size", "Qty", "Price"};
	    
	    
	    JTable jt = new JTable(data, column) {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
	    jt.setBounds(100,100,200,300); 
	    
	    
	    JScrollPane sp=new JScrollPane(jt); 
	    sp.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));


	    JLabel l = new JLabel("Food Items");
	    l.setBorder(BorderFactory.createEmptyBorder(10, 650, 10, 10));
	    
	    
	    addFood = new JButton("Add Food Item");
	    addFood.setBounds(160,700,200,40);
	    addFood.addActionListener(this);
	    frame.add(addFood);
	    
	    deleteFood = new JButton("Delete Food Item");
	    deleteFood.setBounds(400,700,200,40);
	    deleteFood.addActionListener(this);
	    frame.add(deleteFood);
	    
	    updateFood = new JButton("Update Food Item");
	    updateFood.setBounds(640,700,200,40);
	    updateFood.addActionListener(this);
	    frame.add(updateFood);
	    
	    backToDash = new JButton("Back");
	    backToDash.setBounds(880,700,200,40);
	    backToDash.addActionListener(this);
	    frame.add(backToDash);
	    
	    
	    frame.add(l); 
	    frame.add(sp);          
	    frame.getContentPane().add(BorderLayout.NORTH, l);
        frame.getContentPane().add(BorderLayout.CENTER, sp);
	    frame.setSize(1920,1080);    
	    frame.setVisible(true);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public void updateFoodItems(Food f) {
		frame = new JFrame("Update Product");
		panel = new JPanel(new GridLayout(9,4));
		
		JLabel heading = new JLabel("Update Product:");
		JLabel emptyHeading = new JLabel("");
		
		JLabel label_id = new JLabel("Product ID: ");
		text_id = new JTextField(f.getFoodId());
		text_id.setEditable(false);
		text_id.addActionListener(this);
		
		JLabel label_name = new JLabel("Product Name: ");
		text_name = new JTextField(f.getName());
		text_name.addActionListener(this);
		
		JLabel label_type = new JLabel("Product Type: ");
		text_type = new JTextField(f.getType());
		text_type.addActionListener(this);
		
		JLabel label_size = new JLabel("Product Size: ");
		text_size = new JTextField(f.getFoodSize());
		text_size.addActionListener(this);
		
		JLabel label_qty = new JLabel("Product Quantity: ");
		text_qty = new JTextField(String.valueOf(f.getQuantity()));
		text_qty.addActionListener(this);
		
		JLabel label_price = new JLabel("Product Price: ");
		text_price = new JTextField(String.valueOf(f.getPrice()));
		text_price.addActionListener(this);
		
		updateFoodQueryFinal = new JButton("Update Product!");
		updateFoodQueryFinal.addActionListener(this);
		
		JLabel emptyHeading2 = new JLabel("");
		JLabel emptyHeading3 = new JLabel("");
		JLabel emptyHeading4 = new JLabel("");
		
		panel.add(heading);
		panel.add(emptyHeading);
		panel.add(label_id);
		panel.add(text_id);
		panel.add(label_name);
		panel.add(text_name);
		panel.add(label_type);
		panel.add(text_type);
		panel.add(label_size);
		panel.add(text_size);
		panel.add(label_qty);
		panel.add(text_qty);
		panel.add(label_price);
		panel.add(text_price);
		panel.add(emptyHeading2);
		panel.add(emptyHeading3);
		panel.add(updateFoodQueryFinal);
		panel.add(emptyHeading4);
		
		panel.setBorder(BorderFactory.createEmptyBorder(100, 50, 100, 50));
		
		frame.add(panel);
		frame.setSize(1920,1080);    
	    frame.setVisible(true);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void deleteFoodItems() {
		frame = new JFrame("Delete Product");
		panel = new JPanel(new GridLayout(5,2));
		
		JLabel heading = new JLabel("Enter Product ID:");
		JLabel emptyHeading = new JLabel("");
		JLabel emptyHeading1 = new JLabel("");
		JLabel emptyHeading2= new JLabel("");
		
		JLabel label_id = new JLabel("Product ID: ");
		text_id = new JTextField();
		text_id.addActionListener(this);
		
		deleteFoodQuery = new JButton("Delete Product");
		deleteFoodQuery.addActionListener(this);
		
		JLabel emptyHeading3 = new JLabel("");
		JLabel emptyHeading4= new JLabel("");
		
		panel.add(heading);
		panel.add(emptyHeading);
		panel.add(emptyHeading1);
		panel.add(emptyHeading2);
		panel.add(label_id);
		panel.add(text_id);
		panel.add(emptyHeading3);
		panel.add(emptyHeading4);
		panel.add(deleteFoodQuery);
		panel.setBorder(BorderFactory.createEmptyBorder(200, 100, 200, 100));
		
		frame.add(panel);
		frame.setSize(1920,1080);    
	    frame.setVisible(true);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			
	}
	public void addFoodItems() {
		frame = new JFrame("Add Product");
		panel = new JPanel(new GridLayout(9,4));
		
		JLabel heading = new JLabel("Add Product:");
		JLabel emptyHeading = new JLabel("");
		
		JLabel label_name = new JLabel("Product Name: ");
		text_name = new JTextField();
		text_name.addActionListener(this);
		
		JLabel label_type = new JLabel("Product Type: ");
		text_type = new JTextField();
		text_type.addActionListener(this);
		
		JLabel label_size = new JLabel("Product Size: ");
		text_size = new JTextField();
		text_size.addActionListener(this);
		
		JLabel label_qty = new JLabel("Product Quantity: ");
		text_qty = new JTextField();
		text_qty.addActionListener(this);
		
		JLabel label_price = new JLabel("Product Price: ");
		text_price = new JTextField();
		text_price.addActionListener(this);
		
		addFoodQuery = new JButton("Add Product!");
		addFoodQuery.addActionListener(this);
		
		JLabel emptyHeading2 = new JLabel("");
		JLabel emptyHeading3 = new JLabel("");
		JLabel emptyHeading4 = new JLabel("");
		
		panel.add(heading);
		panel.add(emptyHeading);
		panel.add(label_name);
		panel.add(text_name);
		panel.add(label_type);
		panel.add(text_type);
		panel.add(label_size);
		panel.add(text_size);
		panel.add(label_qty);
		panel.add(text_qty);
		panel.add(label_price);
		panel.add(text_price);
		panel.add(emptyHeading2);
		panel.add(emptyHeading3);
		panel.add(addFoodQuery);
		panel.add(emptyHeading4);
		
		panel.setBorder(BorderFactory.createEmptyBorder(100, 50, 100, 50));
		
		frame.add(panel);
		frame.setSize(1920,1080);    
	    frame.setVisible(true);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	public void searchForUpdate()
	{
		frame = new JFrame("Update Product:");
		panel = new JPanel(new GridLayout(5,2));
		
		JLabel heading = new JLabel("Enter Product ID:");
		JLabel emptyHeading = new JLabel("");
		JLabel emptyHeading1 = new JLabel("");
		JLabel emptyHeading2= new JLabel("");
		
		JLabel label_id = new JLabel("Product ID: ");
		text_id = new JTextField();
		text_id.addActionListener(this);
		
		updateFoodQuery = new JButton("Update Product");
		updateFoodQuery.addActionListener(this);
		
		JLabel emptyHeading3 = new JLabel("");
		JLabel emptyHeading4= new JLabel("");
		
		panel.add(heading);
		panel.add(emptyHeading);
		panel.add(emptyHeading1);
		panel.add(emptyHeading2);
		panel.add(label_id);
		panel.add(text_id);
		panel.add(emptyHeading3);
		panel.add(emptyHeading4);
		panel.add(updateFoodQuery);
		panel.setBorder(BorderFactory.createEmptyBorder(200, 100, 200, 100));
		
		frame.add(panel);
		frame.setSize(1920,1080);    
	    frame.setVisible(true);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == addFood)
		{
			this.frame.dispose();
			new FoodItems().addFoodItems();
		}
		else if(ae.getSource() == deleteFood)
		{
			this.frame.dispose();
			new FoodItems().deleteFoodItems();
		}
		else if(ae.getSource() == updateFood)
		{
			this.frame.dispose();
			new FoodItems().searchForUpdate();
		}
		else if(ae.getSource() == addFoodQuery)
		{
			Food f = new Food();
			f.setName(text_name.getText());
			f.setFoodSize(text_size.getText());
			f.setPrice(Integer.parseInt(text_price.getText()));
			f.setQuantity(Integer.parseInt(text_qty.getText()));
			f.setType(text_type.getText());
			
			try {
				ad.addFoodItem(f);
				this.frame.dispose();
				new FoodItems().setFoodItems();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == deleteFoodQuery)
		{
			String foodId = text_id.getText();
			try {
				ad.deleteFoodItem(foodId);
				this.frame.dispose();
				new FoodItems().setFoodItems();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == updateFoodQueryFinal)
		{
			Food f = new Food();
			f.setFoodId(text_id.getText());
			f.setName(text_name.getText());
			f.setFoodSize(text_size.getText());
			f.setPrice(Integer.parseInt(text_price.getText()));
			f.setQuantity(Integer.parseInt(text_qty.getText()));
			f.setType(text_type.getText());
			
			try {
				ad.updateFoodItem(f);
				this.frame.dispose();
				new FoodItems().setFoodItems();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == updateFoodQuery) {
			try {
				System.out.println(text_id.getText());
				Food f = ad.getFoodbyID(text_id.getText());
				if (f!=null) {
					this.frame.dispose();
					new FoodItems().updateFoodItems(f);
				}
				else
					throw new SQLException("ID not available");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == backToDash)
		{
			this.frame.dispose();
			new AdminDashboard().createDashboard();
		}
		
	}
	
	public static void main(String[] args) throws SQLException {
		new FoodItems().setFoodItems();
	}
}
