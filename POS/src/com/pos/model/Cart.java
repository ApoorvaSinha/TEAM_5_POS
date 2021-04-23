package com.pos.model;

import java.sql.Timestamp;


public class Cart {

	private int cartId;
	private String userId;
	private String foodId;
	private String type;
	private int quantity;
	private int cost;
	private Timestamp orderDate;
	
	public Cart()
	{
		
	}
	
	public Cart(int cartId, String userId, String foodId, String type,
			int quantity, int cost, Timestamp orderDate) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.foodId = foodId;
		this.type = type;
		this.quantity = quantity;
		this.cost = cost;
		this.orderDate = orderDate;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFoodId() {
		return foodId;
	}

	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", foodId="
				+ foodId + ", type=" + type + ", quantity=" + quantity
				+ ", cost=" + cost + ", orderDate=" + orderDate + "]";
	}
	
	
	
	
	

}
