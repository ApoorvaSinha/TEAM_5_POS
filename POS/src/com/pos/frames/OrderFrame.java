/*
 Frame to display order details
 Functionality: - display all orders placed by customer
 				- back button feature to switch bak to admin dashboard
 				- accessible only to admin
*/

package com.pos.frames;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.pos.dao.OrderDao;
import com.pos.model.Food;
import com.pos.model.Order;

public class OrderFrame extends javax.swing.JFrame implements ActionListener {

	JFrame frame;
	JPanel panel;
	JButton backToDash;

	public void setOrder() throws SQLException
	{   
		frame=new JFrame("Order Details");  
		OrderDao od = new OrderDao();

		String[][] data;
		
		
			ArrayList<Order> orderList = od.getOrder();
			
			// use of Stream API
			List<Order> arr=orderList.stream().sorted((f1,f2)->
			 Integer.parseInt(f2.getOrderId())-Integer.parseInt(f1.getOrderId())).
			  collect(Collectors.toList());
			
			System.out.println(arr);
			
			
		orderList=(ArrayList<Order>) arr;
		data = new String[orderList.size()][10];
		
		
		
		for(int i=0; i<orderList.size(); i++)
		{
			data[i][0] = orderList.get(i).getOrderId();
			data[i][1] = orderList.get(i).getUserId();
			data[i][2] = String.valueOf(orderList.get(i).getOrderDate());
			data[i][3] = String.valueOf(orderList.get(i).getTotalPrice());
			data[i][4] =orderList.get(i).getOrderStatus();
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
		new OrderFrame().setOrder();
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
