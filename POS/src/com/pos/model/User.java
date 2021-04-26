package com.pos.model;
import java.sql.Date;

//User class with getters,setters, default and parameterized constructors, toString

public class User {

	private String userId;
	private String firstName;
	private String lastName;
	private Date dob;
	private char gender;
	private String street;
	private String location;
	private String city;
	private String state;
	private String zipcode;
	private String mobileNo;
	private String emailId;
	
	
	public User()
	{
		
	}
	
	



	public User(String userId, String firstName, String lastName, Date dob, char gender, String street, String location,
			String city, String state, String zipcode, String mobileNo, String emailId) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.street = street;
		this.location = location;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}


	public User( String firstName, String lastName, Date dob, char gender, String street, String location,
			String city, String state, String zipcode, String mobileNo, String emailId) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.street = street;
		this.location = location;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}




	public String getUserId() {
		return userId;
	}





	public void setUserId(String userId) {
		this.userId = userId;
	}









	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", gender=" + gender + ", street=" + street + ", location=" + location + ", city=" + city + ", state="
				+ state + ", zipcode=" + zipcode + ", mobileNo=" + mobileNo + ", emailId=" + emailId + "]";
	}








	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
}
