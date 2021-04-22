package com.pos.frames;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Order_Frame extends javax.swing.JFrame {

	JFrame frame;
	JPanel panel;
	
	
	public Order_Frame()
	{   
		frame=new JFrame("Order Details");    
	    String data[][]={ 
		    		
		    		{"oid1001", "ab1001", "2018-09-01 09:01:15", "st1001", "500","Active","ct1001","street1","city1","state1","987654","9876543218"},    
		    		{"oid1002", "ab1002", "2019-09-01 09:01:15", "st1002", "400","Active","ct1003","street2","city2","state2","776567","6345272823"},       
		    		{"oid1003", "ab1003", "2020-09-01 09:01:15", "st1003", "300","inActive","ct1002","street3","city3","state3","987654","2536327299"}    
	    		};    
	    String column[]={"OrderId", "UserId","OrderDate", "StoreId","TotalPrice", "OrderStatus","CartId","Street","City","State","Pincode","MobileNo"};
	   
	    JTable jt=new JTable(data,column);    
	    jt.setBounds(100,100,200,300); 
	    
	    
	    JScrollPane sp=new JScrollPane(jt); 
	    sp.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));


	    
	    JLabel l = new JLabel("Order Details");
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
		new Order_Frame();
	}
}
