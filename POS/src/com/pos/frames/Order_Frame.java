package com.pos.frames;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.pos.dao.AdminDAO;
import com.pos.dao.OrderDao;
import com.pos.model.Food;
import com.pos.model.Order;

public class Order_Frame extends javax.swing.JFrame {

	JFrame frame;
	JPanel panel;

	public void setOrder() throws SQLException
	{   
		frame=new JFrame("Order Details");  
		OrderDao od = new OrderDao();
//		/*
//		 * String data[][]={
//		 * 
//		 * {"oid1001", "ab1001", "2018-09-01 09:01:15", "st1001",
//		 * "500","Active","ct1001","street1","city1","state1","987654","9876543218"},
//		 * {"oid1002", "ab1002", "2019-09-01 09:01:15", "st1002",
//		 * "400","Active","ct1003","street2","city2","state2","776567","6345272823"},
//		 * {"oid1003", "ab1003", "2020-09-01 09:01:15", "st1003",
//		 * "300","inActive","ct1002","street3","city3","state3","987654","2536327299"}
//		 * };
//		 */
		String[][] data;
		
		
			ArrayList<Order> orderList = od.getOrder();
		
		
		data = new String[orderList.size()][6];
		
		for(int i=0; i<orderList.size(); i++)
		{
			data[i][0] = orderList.get(i).getOrderId();
			data[i][1] = orderList.get(i).getUserId();
			data[i][2] = String.valueOf(orderList.get(i).getOrderDate());
			data[i][3] = orderList.get(i).getStoreId();
			data[i][4] = String.valueOf(orderList.get(i).getTotalPrice());
			data[i][5] =orderList.get(i).getOrderStatus();
			data[i][5] =String.valueOf(orderList.get(i).getCartId());
			data[i][5] =orderList.get(i).getStreet();
			data[i][5] =orderList.get(i).getCity();
			data[i][5] =orderList.get(i).getState();
			data[i][5] =orderList.get(i).getPincode();
			data[i][5] =orderList.get(i).getMobileNo();
			
		}
		
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

	public static void main(String[] args) throws SQLException {
		new Order_Frame().setOrder();
	}
}
