package com.pos.model;

//Order class with getters,setters, default and parameterized constructors, toString
import java.sql.Timestamp;

public class Order {

	private String orderId;
	private String userId;
	private Timestamp orderDate;
	private String storeId;
	private int totalPrice;
	private String orderStatus;
	private int cartId;
	private String street;
	private String city;
	private String state;
	private String pincode;
	private String mobileNo;

	public Order(String orderId, String userId, Timestamp orderDate,
			String storeId, int totalPrice, String orderStatus, int cartId,
			String street, String city, String state, String pincode,
			String mobileNo) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.storeId = storeId;
		this.totalPrice = totalPrice;
		this.orderStatus = orderStatus;
		this.cartId = cartId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobileNo = mobileNo;
	}
	
	
	
	public Order() {
		super();
	}



	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", orderDate=" + orderDate + ", storeId=" + storeId
				+ ", totalPrice=" + totalPrice + ", orderStatus=" + orderStatus + ", cartId=" + cartId + ", street="
				+ street + ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", mobileNo=" + mobileNo
				+ "]";
	}

}
