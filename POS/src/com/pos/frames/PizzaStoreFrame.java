package com.pos.frames;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import com.pos.dao.AdminDAO;
import com.pos.model.PizzaStore;

public class PizzaStoreFrame implements ActionListener{
	
	JFrame frame;
	JPanel panel;
	JButton addStore, deleteStore, updateStore,addPizzaStoreQuery,deleteStoreQuery,updateStoreQuery,updateStoreQueryFinal,backToDash;
	JTextField text_name,text_mobile, text_street, text_city, text_state, text_pin,text_id;
	AdminDAO ad = new AdminDAO();
		
	public void setPizzaStore() throws SQLException
	{   
		frame=new JFrame("Pizza Stores");  
		
		String[][] data;
		
		ArrayList<PizzaStore> storeList = ad.getAllPizzaStore();
		
		data = new String[storeList.size()][7];
		
		for(int i=0; i<storeList.size(); i++)
		{
			data[i][0] = storeList.get(i).getStoreId();
			data[i][1] = storeList.get(i).getName();
			data[i][2] = storeList.get(i).getMobileNo();
			data[i][3] = storeList.get(i).getStreet();
			data[i][4] = storeList.get(i).getCity();
			data[i][5] = storeList.get(i).getState();
			data[i][6] = storeList.get(i).getPincode();
		}
		
	
	    String column[]={"Store ID", "Name", "Mobile Number", "Street", "City", "State", "Pincode"};
	    
	    
	    JTable jt = new JTable(data, column) {
	        private static final long serialVersionUID = 1L;
	
	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
	    jt.setBounds(100,100,200,300); 
	    
	    
	    JScrollPane sp=new JScrollPane(jt); 
	    sp.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
	
	
	    JLabel l = new JLabel("Store ID");
	    l.setBorder(BorderFactory.createEmptyBorder(10, 650, 10, 10));
	    
	    
	    addStore = new JButton("Add Pizza Store");
	    addStore.setBounds(160,700,200,40);
	    addStore.addActionListener(this);
	    frame.add(addStore);
	    
	    deleteStore = new JButton("Delete Food Item");
	    deleteStore.setBounds(400,700,200,40);
	    deleteStore.addActionListener(this);
	    frame.add(deleteStore);
	    
	    updateStore = new JButton("Update Food Item");
	    updateStore.setBounds(640,700,200,40);
	    updateStore.addActionListener(this);
	    frame.add(updateStore);
	    
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

	public void updateStore(PizzaStore p) {
		frame = new JFrame("Update Store");
		panel = new JPanel(new GridLayout(10,4));
		
		JLabel heading = new JLabel("Update Store Details:");
		JLabel emptyHeading = new JLabel("");
		
		JLabel label_id = new JLabel("Store ID: ");
		text_id = new JTextField(p.getStoreId());
		text_id.setEditable(false);
		text_id.addActionListener(this);
		
		JLabel label_name = new JLabel("Store Name: ");
		text_name = new JTextField(p.getName());
		text_name.addActionListener(this);
		
		JLabel label_mobile = new JLabel("Mobile Number: ");
		text_mobile = new JTextField(p.getMobileNo());
		text_mobile.addActionListener(this);
		
		JLabel label_street = new JLabel("Street: ");
		text_street = new JTextField(p.getStreet());
		text_street.addActionListener(this);
		
		JLabel label_city = new JLabel("City: ");
		text_city = new JTextField(p.getCity());
		text_city.addActionListener(this);
		
		JLabel label_state = new JLabel("State: ");
		text_state = new JTextField(p.getState());
		text_state.addActionListener(this);
		
		JLabel label_pin = new JLabel("PIN Code: ");
		text_pin= new JTextField(p.getPincode());
		text_pin.addActionListener(this);
		
		updateStoreQueryFinal= new JButton("Update Details");
		updateStoreQueryFinal.addActionListener(this);
		
		JLabel emptyHeading2 = new JLabel("");
		JLabel emptyHeading3 = new JLabel("");
		JLabel emptyHeading4 = new JLabel("");
		
		panel.add(heading);
		panel.add(emptyHeading);
		panel.add(label_id);
		panel.add(text_id);
		panel.add(label_name);
		panel.add(text_name);
		panel.add(label_mobile);
		panel.add(text_mobile);
		panel.add(label_street);
		panel.add(text_street);
		panel.add(label_city);
		panel.add(text_city);
		panel.add(label_state);
		panel.add(text_state);
		panel.add(label_pin);
		panel.add(text_pin);
		panel.add(emptyHeading2);
		panel.add(emptyHeading3);
		panel.add(updateStoreQueryFinal);
		panel.add(emptyHeading4);
		
		panel.setBorder(BorderFactory.createEmptyBorder(100, 50, 100, 50));
		
		frame.add(panel);
		frame.setSize(1920,1080);    
	    frame.setVisible(true);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void deletePizzaStore() {
		frame = new JFrame("Delete Store");
		panel = new JPanel(new GridLayout(5,2));
		
		JLabel heading = new JLabel("Enter Store ID:");
		JLabel emptyHeading = new JLabel("");
		JLabel emptyHeading1 = new JLabel("");
		JLabel emptyHeading2= new JLabel("");
		
		JLabel label_id = new JLabel("Store ID: ");
		text_id = new JTextField();
		text_id.addActionListener(this);
		
		deleteStoreQuery = new JButton("Delete Store");
		deleteStoreQuery.addActionListener(this);
		
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
		panel.add(deleteStoreQuery);
		panel.setBorder(BorderFactory.createEmptyBorder(200, 100, 200, 100));
		
		frame.add(panel);
		frame.setSize(1920,1080);    
	    frame.setVisible(true);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			
	}
	public void addPizzaStore() {
		frame = new JFrame("Add Store");
		panel = new JPanel(new GridLayout(10,4));
		
		JLabel heading = new JLabel("Add Store:");
		JLabel emptyHeading = new JLabel("");
		
		JLabel label_name = new JLabel("Store Name: ");
		text_name = new JTextField();
		text_name.addActionListener(this);
		
		JLabel label_mobile = new JLabel("Mobile Number: ");
		text_mobile = new JTextField();
		text_mobile.addActionListener(this);
		
		JLabel label_street = new JLabel("Street: ");
		text_street = new JTextField();
		text_street.addActionListener(this);
		
		JLabel label_city = new JLabel("City: ");
		text_city = new JTextField();
		text_city.addActionListener(this);
		
		JLabel label_state = new JLabel("State: ");
		text_state = new JTextField();
		text_state.addActionListener(this);
		
		JLabel label_pin = new JLabel("PIN Code: ");
		text_pin= new JTextField();
		text_pin.addActionListener(this);
		
		addPizzaStoreQuery= new JButton("Add Store!");
		addPizzaStoreQuery.addActionListener(this);
		
		JLabel emptyHeading2 = new JLabel("");
		JLabel emptyHeading3 = new JLabel("");
		JLabel emptyHeading4 = new JLabel("");
		
		panel.add(heading);
		panel.add(emptyHeading);
		panel.add(label_name);
		panel.add(text_name);
		panel.add(label_mobile);
		panel.add(text_mobile);
		panel.add(label_street);
		panel.add(text_street);
		panel.add(label_city);
		panel.add(text_city);
		panel.add(label_state);
		panel.add(text_state);
		panel.add(label_pin);
		panel.add(text_pin);
		panel.add(emptyHeading2);
		panel.add(emptyHeading3);
		panel.add(addPizzaStoreQuery);
		panel.add(emptyHeading4);
		
		panel.setBorder(BorderFactory.createEmptyBorder(100, 50, 100, 50));
		
		frame.add(panel);
		frame.setSize(1920,1080);    
	    frame.setVisible(true);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	public void searchForUpdate()
	{
		frame = new JFrame("Update Store Details:");
		panel = new JPanel(new GridLayout(5,2));
		
		JLabel heading = new JLabel("Enter Store ID:");
		JLabel emptyHeading = new JLabel("");
		JLabel emptyHeading1 = new JLabel("");
		JLabel emptyHeading2= new JLabel("");
		
		JLabel label_id = new JLabel("Store ID: ");
		text_id = new JTextField();
		text_id.addActionListener(this);
		
		updateStoreQuery = new JButton("Update Store");
		updateStoreQuery.addActionListener(this);
		
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
		panel.add(updateStoreQuery);
		panel.setBorder(BorderFactory.createEmptyBorder(200, 100, 200, 100));
		
		frame.add(panel);
		frame.setSize(1920,1080);    
	    frame.setVisible(true);   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == addStore)
		{
			this.frame.dispose();
			new PizzaStoreFrame().addPizzaStore();
		}
		else if(ae.getSource() == deleteStore)
		{
			this.frame.dispose();
			new PizzaStoreFrame().deletePizzaStore();
		}
		else if(ae.getSource() == updateStore)
		{
			this.frame.dispose();
			new PizzaStoreFrame().searchForUpdate();
		}
		else if(ae.getSource() == addPizzaStoreQuery)
		{
			PizzaStore p = new PizzaStore();
			
			p.setName(text_name.getText());
			p.setMobileNo(text_mobile.getText());
			p.setStreet(text_street.getText());
			p.setCity(text_city.getText());
			p.setState(text_state.getText());
			p.setPincode(text_pin.getText());
			
			try {
				ad.addPizzaStore(p);
				this.frame.dispose();
				new PizzaStoreFrame().setPizzaStore();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == deleteStoreQuery)
		{
			String storeId = text_id.getText();
			try {
				ad.deletePizzaStore(storeId);
				this.frame.dispose();
				new PizzaStoreFrame().setPizzaStore();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == updateStoreQueryFinal)
		{
			PizzaStore p = new PizzaStore();
			p.setStoreId(text_id.getText());
			p.setName(text_name.getText());
			p.setMobileNo(text_mobile.getText());
			p.setStreet(text_street.getText());
			p.setCity(text_city.getText());
			p.setState(text_state.getText());
			p.setPincode(text_pin.getText());
			try {
				ad.updatePizzaStore(p);
				this.frame.dispose();
				new PizzaStoreFrame().setPizzaStore();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == updateStoreQuery) {
			try {
				System.out.println(text_id.getText());
				PizzaStore p = ad.getStorebyID(text_id.getText());
				if (p!=null) {
					this.frame.dispose();
					new PizzaStoreFrame().updateStore(p);
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
		new PizzaStoreFrame().setPizzaStore();
	}
}


