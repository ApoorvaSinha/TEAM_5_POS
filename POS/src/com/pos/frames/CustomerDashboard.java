/*
 Frame for Customer dashboard
 Functionality: - user can place order
 				- select pizza and size of pizza
 					if size are same for same pizza:
 						add onto the exsisting item in cart
 						
 					else if size are not same for same pizza
 						create new item in cart
 				
 				- review order button to check the cart
 				- logout button for logout
 				- clear button to clear all selection
 					 
*/

package com.pos.frames;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;
import com.pos.dao.AdminDAO;
import com.pos.model.Food;
import com.pos.model.UserCredentials;

public class CustomerDashboard extends JFrame
{
	ArrayList<Food> arr=new ArrayList<>();
	Map<String,Food> map=new HashMap<>();
    private JLabel name = new JLabel("Customer Name:");
    private JLabel email = new JLabel("Email Address:");
    private JLabel telNo = new JLabel("Telephone No:");
    private JLabel pizza = new JLabel("Pizza Type:");
    private JLabel crust = new JLabel("Pizza Name:");
    private JLabel image = new JLabel("");
    private JLabel size = new JLabel("Size:");
    private JLabel info = new JLabel("Pizza info:");
    private JLabel quantiy = new JLabel("Quantity");

    private JTextField tName = new JTextField();
    private JTextField tEmail = new JTextField();
    private JTextField tTelNo = new JTextField();
    
    
    private String[] pizzaType= {"Cheese & Tomatoes", "Vegetarian", "Anchovies", "Superb meat lover", "Juicy chicken", "All cheezey", "Seafood heaven", "Sambal berapi"};
    private JList lPizza = new JList(pizzaType);
    private JScrollPane scrollPizza = new JScrollPane(lPizza);

    private String[] pizzaName; //private String comboSize;
   // private double pizzaPrice;
    private String[] comboSize = {"Personal 6 inch", "Regular 9 inch", "Large 12 inch", "Extra large 15 inch"};
    private String[] cQuantity= {"1","2","3","4","5"};
    
    //private double[] pizzaPrice = {10.00, 20.00, 25.00, 30.00};
    private String[] foodId;
    private JComboBox cCrust;
    private JComboBox cSize = new JComboBox(comboSize);
    private JComboBox cQu= new JComboBox(cQuantity);
    

    private JRadioButton delivery = new JRadioButton("Delivery", true);
    private JRadioButton pickUp = new JRadioButton("Pick up", true);

    private JButton submit = new JButton("Add to cart");
    private JButton clear = new JButton("Clear");
    private JButton reviewOrder= new JButton("reviewOrder");
    private JButton logout = new JButton("Log Out"); 					//////////////////////////////////////////////////
        
    private JTextArea aInfo = new JTextArea(1, 2);

    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();

    private int amount;
    //int[] pizzaItem;
    String selected = "";
    int cost[];
    UserCredentials cred;
    public void getData() throws SQLException {
		AdminDAO ad = new AdminDAO();
		
		String[][] data;
		
		ArrayList<Food> foodList = ad.getAllFoodItems();
		pizzaName=new String[foodList.size()];
		cost=new int[foodList.size()];
		foodId=new String[foodList.size()];
		data = new String[foodList.size()][6];
		
		for(int i=0; i<foodList.size(); i++)
		{
			data[i][0] = foodList.get(i).getFoodId();
			data[i][1] = foodList.get(i).getName();
			data[i][2] = foodList.get(i).getType();
			pizzaName[i]=foodList.get(i).getName();
			cost[i]=foodList.get(i).getPrice();
			foodId[i]=foodList.get(i).getFoodId();
			// address 
			data[i][3] = foodList.get(i).getFoodSize();
			data[i][4] = String.valueOf(foodList.get(i).getQuantity());
			data[i][5] = String.valueOf(foodList.get(i).getPrice());
		}
		cCrust = new JComboBox(pizzaName);
    }
    
    public CustomerDashboard()
    {
    	try {
			this.getData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        lPizza.setVisibleRowCount(4);
        lPizza.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        Container pane = getContentPane();
        pane.setLayout(new GridLayout(2, 1, 5, 5));
    
        JLabel lable=new JLabel("Customer Dashboard");
        
        action listener = new action();
        p1.add(new JLabel(""));
        p1.add(lable);
        p1.setLayout(new GridLayout(7,3, 10,10));
//        p1.add(name);
//        p1.add(tName);
//        p1.add(email);
//        p1.add(tEmail);
//        p1.add(telNo);
//        p1.add(tTelNo);
       // p1.add(pizza);
       // p1.add(scrollPizza);

        
        p1.add(new JLabel(""));
        p1.add(crust);
        
        image.setIcon(new ImageIcon("pizza.png"));
        
        p1.add(image);
        p1.add(cCrust);
        p1.add(size);
        p1.add(new JLabel(""));
        p1.add(cSize);
        p1.add(quantiy);
        p1.add(new JLabel(""));
        p1.add(cQu);
//        p1.add(delivery);
//        p1.add(pickUp);
        p1.add(new JLabel(""));
        p1.add(new JLabel(""));
        p1.add(new JLabel(""));
        p1.add(submit);
        p1.add(new JLabel(""));
        p1.add(clear);
        p1.add(reviewOrder);
        p1.add(new JLabel(""));
        
        logout.addActionListener(listener);			//////////////////////////////////
        p1.add(logout);								///////////////////////////////////
        

        p2.setLayout(new BorderLayout());
        p2.add(info, "West");
        p2.add(aInfo, "Center");
        
        p1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 10));
        p2.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 40));
        
        pane.add(p1);
        pane.add(p2);

        
        delivery.addActionListener(listener);
        pickUp.addActionListener(listener);
        submit.addActionListener(listener);
        clear.addActionListener(listener);
        reviewOrder.addActionListener(listener);
        
        item listener1 = new item();
        lPizza.addListSelectionListener(listener1);
    }

        public CustomerDashboard(UserCredentials cred) {
        	this.cred=cred;
        	try {
    			this.getData();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            lPizza.setVisibleRowCount(4);
            lPizza.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            Container pane = getContentPane();
            pane.setLayout(new GridLayout(2, 1, 5, 5));
        
            JLabel lable=new JLabel("Customer Dashboard");
            
            action listener = new action();
            
            p1.add(new JLabel(""));
            p1.add(lable);
            p1.setLayout(new GridLayout(7,3, 10,10));
//            p1.add(name);
//            p1.add(tName);
//            p1.add(email);
//            p1.add(tEmail);
//            p1.add(telNo);
//            p1.add(tTelNo);
           // p1.add(pizza);
           // p1.add(scrollPizza);
            p1.add(new JLabel(""));
            p1.add(crust);
            
            image.setIcon(new ImageIcon("pizza.png"));
            
            p1.add(image);
            p1.add(cCrust);
            p1.add(size);
            p1.add(new JLabel(""));
            p1.add(cSize);
            p1.add(quantiy);
            p1.add(new JLabel(""));
            p1.add(cQu);
            //        p1.add(delivery);
//            p1.add(pickUp);
            p1.add(new JLabel(""));
            p1.add(new JLabel(""));
            p1.add(new JLabel(""));
            p1.add(submit);
            p1.add(new JLabel(""));
            p1.add(clear);
            p1.add(reviewOrder);
            p1.add(new JLabel(""));
            

            logout.addActionListener(listener);			//////////////////////////////////
            p1.add(logout);								///////////////////////////////////
            

            p2.setLayout(new BorderLayout());
            p2.add(info, "West");
            p2.add(aInfo, "Center");
            
            p1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 10));
            p2.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 40));

            pane.add(p1);
            pane.add(p2);

            
            delivery.addActionListener(listener);
            pickUp.addActionListener(listener);
            submit.addActionListener(listener);
            clear.addActionListener(listener);
            reviewOrder.addActionListener(listener);
            
            item listener1 = new item();
            lPizza.addListSelectionListener(listener1);
	}

		class action implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                Object choice = e.getSource();
                //Object radioB = e.getSource();
                Food temp=new Food();
                if (choice == submit)
                {
                    String item1 = tName.getText();
                    String item2 = tEmail.getText();
                    String item3 = tTelNo.getText();
                    
                    arr=new ArrayList<Food>();
                    int item4 = cCrust.getSelectedIndex();
                    int item5 = cSize.getSelectedIndex();
                    int qu=cQu.getSelectedIndex();
                    
                        if (cSize.getSelectedItem().equals("Personal 6 inch"))
                        {
                           amount=0;
                        }
                        else if (cSize.getSelectedItem().equals("Regular 9 inch"))
                        {
                            amount = 20+5;
                        }
                        else if (cSize.getSelectedItem().equals("Large 12 inch"))
                        {
                            amount = 25+5;
                        }
                        else if (cSize.getSelectedItem().equals("Extra large 15 inch"))
                        {
                            amount = 30+5;
                        }
                    
                    
                    System.out.println(amount);
                    temp.setQuantity(Integer.parseInt(cQuantity[qu]));
                    temp.setName(pizzaName[item4]);
                    temp.setPrice(cost[item4]);
                    temp.setFoodId(foodId[item4]);
                    temp.setFoodSize(comboSize[item5] );
                    temp.setPrice((temp.getPrice()+amount)*temp.getQuantity());
                    String key=temp.getFoodId()+"."+temp.getFoodSize().substring(0,2);
                    if(map.containsKey(key))
                    {
                    	if(map.get(key)
                    			.getFoodSize().equals(temp.getFoodSize()))
                    	{
                    		Food t2=map.get(key);
                    		t2.setQuantity(temp.getQuantity()+t2.getQuantity());
                    		t2.setPrice(t2.getPrice()+temp.getPrice());
                    		map.put(key,t2);
                    	}
                    	else {
                    		map.put(key, temp);
                    	}
                    }
                    else {
                    	map.put(key, temp);
                    }
                    System.out.println(map);
                    //arr.add(temp);
                    String str="";
                	
                    for (Food t3: map.values())
                    {
                    	arr.add(t3);
                    }
                   
                    	
                		
                    
                    for(Food f:arr)
                    {
                    	System.out.println(f);
                    	str+= "\n" + item2 + "\n" + 
                                item3 + "\n" + selected + "\n" + f.getName() + 
                                "\n" + f.getFoodSize()+ "\nQuantity: " + f.getQuantity()+ "\nTotal price: INR " +  
                                String.valueOf(f.getPrice());
                    	
                    }
                    
                    aInfo.setText(str);
                    arr=new ArrayList<Food>();
                }

                else if (choice == clear)
                {
                    aInfo.setText("");
                    arr=new ArrayList<Food>();
                    map=new HashMap<String,Food>();
                }
                 if(choice == reviewOrder)
                {
                	   for (Food t3: map.values())
                       {
                       	arr.add(t3);
                       }
                	 System.out.println("This"+" "+this);
                	 System.out.println("This Test"+" "+CustomerDashboard.this);
                	 
                	 CustomerDashboard.this.dispose();
                	 
                	 try {
                		 System.out.println("For");
                         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                             if ("Nimbus".equals(info.getName())) {
                                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                 System.out.println("A");
                                 break;
                             }
                         }
                     } catch (Exception e2) {
                    	 System.out.println(e2);
                     }
                     //</editor-fold>

                     /* Create and display the form */
                     java.awt.EventQueue.invokeLater(new Runnable() {
                         public void run() {
                        	 System.out.println("Bs");
                             
                        	 new Cart(arr,cred).setVisible(true);
                         }
                     });
                }
                 else if(choice == logout)
                 {
                	CustomerDashboard.this.dispose();
                	new Login();
                 }
                 
            }
        }

        class item implements ListSelectionListener
        {
            public void valueChanged(ListSelectionEvent e)
            {
                String str = "";
                int selectedIndex[] = lPizza.getSelectedIndices();
                for (int i=0; i<selectedIndex.length; i++)
                {
                    int index = selectedIndex[i];
                    str += pizzaType[index];
                }
                selected = str;
            }

         }

public static void main (String []args)
{
	CustomerDashboard frame = new CustomerDashboard();
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setTitle("Order your pizza from PizzaLand. Satisfaction guaranteed!");
   frame.setSize(650, 650);
   frame.setVisible(true);

}
}
