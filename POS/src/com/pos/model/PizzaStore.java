package com.pos.model;

//Pizza Store class with getters,setters, default and parameterized constructors, toString
public class PizzaStore {
	private String storeId;
	private String name;
	private String street;
	private String mobileNo;
	private String city;
	private String state;
	private String pincode;
	
	
	public PizzaStore()
	{
		
	}


	public PizzaStore(String storeId, String name, String street, String mobileNo, String city, String state,
			String pincode) {
		super();
		this.storeId = storeId;
		this.name = name;
		this.street = street;
		this.mobileNo = mobileNo;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}


	public String getStoreId() {
		return storeId;
	}


	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "PizzaStore [storeId=" + storeId + ", name=" + name + ", street=" + street + ", mobileNo=" + mobileNo
				+ ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
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
	
	
}
