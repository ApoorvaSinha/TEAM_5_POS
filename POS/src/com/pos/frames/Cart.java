/*
 Frame for Cart
 Functionality: - view all products placed in the cart
*/

package com.pos.frames;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import javax.swing.JFrame;

import com.pos.frames.CustomerDashboard.action;
import com.pos.model.Food;
import com.pos.model.UserCredentials;

public class Cart extends javax.swing.JFrame {
	UserCredentials cred;
    public Cart() {
       
    }

    String data[][];
    int totalPrice=0;
    public Cart(ArrayList<Food> arr) {
		System.out.println(arr);
		data=new String[arr.size()][5];
		for(int i=0; i<arr.size(); i++)
		{
			data[i][0] = String.valueOf(i+1);
			data[i][1] = arr.get(i).getName();
			data[i][2] = arr.get(i).getFoodSize();
			data[i][4] = String.valueOf(arr.get(i).getPrice());
			data[i][3] = String.valueOf(arr.get(i).getQuantity());
			totalPrice+=arr.get(i).getPrice();
		}
		 initComponents();
	}


	public Cart(ArrayList<Food> arr, UserCredentials cred) {
		this.cred=cred;
		System.out.println(arr);
		data=new String[arr.size()][5];
		for(int i=0; i<arr.size(); i++)
		{
			
			data[i][0] = String.valueOf(i+1);
			data[i][1] = arr.get(i).getName();
			data[i][2] = arr.get(i).getFoodSize();
			data[i][4] = String.valueOf(arr.get(i).getPrice());
			data[i][3] = String.valueOf(arr.get(i).getQuantity());
			totalPrice+=arr.get(i).getPrice();
		}
		 initComponents();
	}


	@SuppressWarnings("unchecked")                         
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        button1 = new java.awt.Button();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48));
        jLabel1.setText("CART");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
           data,
            new String [] {
                "s.no", "name", "size","quantity", "cost",
            }
        ));
        
        jScrollPane1.setViewportView(jTable1);

        button1.setLabel("Place Order");

        jLabel2.setText("User ID");

        jLabel3.setText("Total Price :");

        jLabel4.setText("INR" +String.valueOf(totalPrice));
        action listener = new action();
        button1.addActionListener(listener);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(91, 91, 91))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(44, 44, 44)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private java.awt.Button button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration     
    

	class action implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Object choice = e.getSource();
            //Object radioB = e.getSource();
            Food temp=new Food();
            if(choice == button1)
            {
            	Cart.this.dispose();
            	new PaymentGateway(cred,totalPrice);
            }
            	//</editor-fold>

                 /* Create and display the form */
                 java.awt.EventQueue.invokeLater(new Runnable() {
                     public void run() {
                    	 System.out.println("Bs");
                         
                    	 
                     }
                 });
            }
        }
    }

