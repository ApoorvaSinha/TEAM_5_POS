package com.pos.frames;


import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import com.pos.dao.AdminDAO;
import com.pos.model.Food;

public class FoodItems {
	JFrame frame;
	JPanel panel;
	
	
	public void setFoodItems() throws SQLException
	{   
		frame=new JFrame("Food Items");  
		AdminDAO ad = new AdminDAO();
		
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
		
//	    String data[][]={ 
//		    		
//		    		{"Double Cheese", "Veg", "Small", "500", "500"},    
//		    		{"Triple Cheese", "Non-Veg", "Medium", "400", "400"},    
//		    		{"Quadruple Cheese", "Veg", "Large", "600", "600"}
//	    		};    
	    
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
	    
	    frame.add(l); 
	    frame.add(sp);          
	    frame.getContentPane().add(BorderLayout.NORTH, l);
        frame.getContentPane().add(BorderLayout.CENTER, sp);
	    frame.setSize(1920,1080);    
	    frame.setVisible(true);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) throws SQLException {
		new FoodItems().setFoodItems();
	}
}
