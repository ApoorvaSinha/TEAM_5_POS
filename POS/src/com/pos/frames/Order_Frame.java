package com.pos.frames;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.pos.dao.AdminDAO;
import com.pos.dao.OrderDao;
import com.pos.model.Food;
import com.pos.model.Order;

public class Order_Frame extends javax.swing.JFrame implements ActionListener {

	JFrame frame;
	JPanel panel;
	JButton backToDash;

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
//			data[i][3] = orderList.get(i).getStoreId();
			data[i][3] = String.valueOf(orderList.get(i).getTotalPrice());
			data[i][4] =orderList.get(i).getOrderStatus();
//			data[i][5] =String.valueOf(orderList.get(i).getCartId());
			data[i][5] =orderList.get(i).getStreet();
			data[i][6] =orderList.get(i).getCity();
			data[i][7] =orderList.get(i).getState();
			data[i][8] =orderList.get(i).getPincode();
			data[i][9] =orderList.get(i).getMobileNo();
			
		}
		
	    String column[]={"OrderId", "UserId","OrderDate","TotalPrice", "OrderStatus","Street","City","State","Pincode","MobileNo"};
	   // storeid, cartid
	    JTable jt=new JTable(data,column);    
	    jt.setBounds(100,100,200,300); 
	    
	    
	    JScrollPane sp=new JScrollPane(jt); 
	    sp.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));


	    
	    JLabel l = new JLabel("Order Details");
	    l.setBorder(BorderFactory.createEmptyBorder(10, 650, 10, 10));
	    
	    backToDash = new JButton("Back");
	    backToDash.setBounds(640,700,200,40);
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

	public static void main(String[] args) throws SQLException {
		new Order_Frame().setOrder();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == backToDash)
		{
			this.frame.dispose();
			new AdminDashboard().createDashboard();
		}
		
	}
}
