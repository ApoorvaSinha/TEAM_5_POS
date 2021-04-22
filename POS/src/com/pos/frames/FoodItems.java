package com.pos.frames;

import java.awt.BorderLayout;

import javax.swing.*;

public class FoodItems {
	JFrame frame;
	JPanel panel;
	
	
	public FoodItems()
	{   
		frame=new JFrame("Food Items");    
	    String data[][]={ 
		    		
		    		{"Double Cheese", "Veg", "Small", "500", "500"},    
		    		{"Triple Cheese", "Non-Veg", "Medium", "400", "400"},    
		    		{"Quadruple Cheese", "Veg", "Large", "600", "600"}
	    		};    
	    
	    String column[]={"Name", "Type", "Size", "Qty", "Price"};
	    
	    JTable jt=new JTable(data,column);    
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
	public static void main(String[] args) {
		new FoodItems();
	}
}
