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
import javax.swing.SwingConstants;

import com.pos.dao.AdminDAO;
import com.pos.model.Food;

class CustomerDashboard2 extends JFrame 
{
	JLabel heading;
	JPanel panel;
	JFrame frame;
	public CustomerDashboard2() {
		frame=new JFrame("Customer Dashboard");
		//panel=new JPanel();
	}
	
	public void menu() throws SQLException {
		AdminDAO ad=new AdminDAO();
		
		
		
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


	    
	    JLabel l = new JLabel("Customer Dashboard");
	    l.setBorder(BorderFactory.createEmptyBorder(10, 650, 10, 10));
	    
	    frame.add(l); 
	    frame.add(sp);          
	    frame.getContentPane().add(BorderLayout.NORTH, l);
        frame.getContentPane().add(BorderLayout.CENTER, sp);
	    frame.setSize(1920,1080);    
	    frame.setVisible(true);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}


class CustomerDashboard
{
	public static void main(String[] args) throws SQLException 
	{
		CustomerDashboard2 gui_obj = new CustomerDashboard2();	
		
		gui_obj.menu();
		
		
		
	}
}