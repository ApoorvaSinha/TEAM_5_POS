/*
 Frame to enter credit card details and complete payment
 Functionality: - fields for name, card number, cvv
*/

package com.pos.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.pos.dao.OrderDao;

import com.pos.dao.UserDAO;
import com.pos.model.Order;
import com.pos.model.User;
import com.pos.model.UserCredentials;

public class PaymentGateway implements ActionListener {
	JFrame f;
	JLabel name;
	JTextField nameText;
	JLabel card;
	JTextField cardText;
	JLabel cvv;
	JTextField cvvText;
	JButton pay;
	UserCredentials cred;
	private int totalPrice;
	public PaymentGateway()
	{
		f=new JFrame("Payment Page");
		JLabel title=new JLabel("Enter your card details for payment");
		title.setBounds(120, -70, 250, 200);
		title.setVisible(true);
		f.add(title);
		
		name=new JLabel("Name");
		name.setBounds(80,50,150,30);
		name.setVisible(true);
		f.add(name);
		
		nameText=new JTextField();
		nameText.setBounds(180, 50, 150, 30);
		nameText.setVisible(true);
		f.add(nameText);
		
		card=new JLabel("Card");
		card.setBounds(80,100,150,30);
		card.setVisible(true);
		f.add(card);
		
		cardText=new JTextField();
		cardText.setBounds(180, 100, 150, 30);
		cardText.setVisible(true);
		f.add(cardText);
		
		
		cvv=new JLabel("Cvv");
		cvv.setBounds(80,150,150,30);
		cvv.setVisible(true);
		f.add(cvv);
		
		cvvText=new JTextField();
		cvvText.setBounds(180, 150, 40, 30);
		cvvText.setVisible(true);
		f.add(cvvText);
		
		
		
		
		
		pay=new JButton("Pay");
		pay.setBounds(70,200, 100, 30);
		pay.setVisible(true);
		pay.addActionListener(this);
		f.add(pay);
		f.setSize(450,350);  
	    f.setLayout(null);  
	    f.setVisible(true);  
		
	}

	public PaymentGateway(UserCredentials cred, int totalPrice) {
		this.cred=cred;
		this.totalPrice=totalPrice;
		f=new JFrame("Payment Page");
		JLabel title=new JLabel("Enter your card details for payment");
		title.setBounds(120, -70, 250, 200);
		title.setVisible(true);
		f.add(title);
		
		name=new JLabel("Name");
		name.setBounds(80,50,150,30);
		name.setVisible(true);
		f.add(name);
		
		nameText=new JTextField();
		nameText.setBounds(180, 50, 150, 30);
		nameText.setVisible(true);
		f.add(nameText);
		
		card=new JLabel("Card");
		card.setBounds(80,100,150,30);
		card.setVisible(true);
		f.add(card);
		
		cardText=new JTextField();
		cardText.setBounds(180, 100, 150, 30);
		cardText.setVisible(true);
		f.add(cardText);
		
		
		cvv=new JLabel("Cvv");
		cvv.setBounds(80,150,150,30);
		cvv.setVisible(true);
		f.add(cvv);
		
		cvvText=new JTextField();
		cvvText.setBounds(180, 150, 40, 30);
		cvvText.setVisible(true);
		f.add(cvvText);
		
		
		
		
		
		pay=new JButton("Pay");
		pay.setBounds(70,200, 100, 30);
		pay.setVisible(true);
		pay.addActionListener(this);
		f.add(pay);
		f.setSize(450,350);  
	    f.setLayout(null);  
	    f.setVisible(true);  
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	    String name = nameText.getText();
        String card = cardText.getText();
        String cvv = cvvText.getText();
        User user=null;
        try {
			 user=new UserDAO().getUser(cred.getUserId());
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		if(e.getSource()==pay)
		{
			if(name.equals(user.getFirstName()+" "+user.getLastName()) && card.length()==16 && cvv.length()==3)
			{
				OrderDao order=new OrderDao();
				Order or=new Order();
				or.setUserId(user.getUserId());
				or.setOrderDate(new Timestamp(System.currentTimeMillis()));
				or.setTotalPrice(totalPrice);
				or.setOrderStatus("P");
				or.setStreet(user.getStreet());
				or.setCity(user.getCity());
				or.setState(user.getState());
				or.setPincode(user.getZipcode());
				or.setMobileNo(user.getMobileNo());
				try {
					order.addOrder(or);
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(f,"Order Confirmed!!!....\n Will be delivered Soon..."); 
				f.dispose();
				new TestFrame(cred);
				TestFrame frame = new TestFrame(cred);
				   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				   frame.setTitle("Order your pizza from PizzaLand. Satisfaction guaranteed!");
				   frame.setSize(650, 650);
				   frame.setVisible(true);	
			}
			else
			{
				
				JOptionPane.showMessageDialog(f,"Enter Valid Details");  
			}
		}
		
	}
	
	
}