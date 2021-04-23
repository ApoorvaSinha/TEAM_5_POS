package com.pos.model;

public class UserCredentials {


	private char userType;
	private String password;
	private String userId;
	public UserCredentials()
	{
		
	}
	
	public UserCredentials(char userType, String password) {
		super();
	
		this.userType = userType;
		this.password = password;
	}
	

	public UserCredentials(char userType, String password, String userId) {
		super();
		this.userType = userType;
		this.password = password;
		this.userId = userId;
	}
	

	public UserCredentials(String password, String userId) {
		super();
		this.password = password;
		this.userId = userId;
	}

	public char getUserType() {
		return userType;
	}
	public void setUserType(char userType) {
		this.userType = userType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String id)
	{
		this.userId=id;
	}

	@Override
	public String toString() {
		return "UserCredentials [userType=" + userType + ", password=" + password + ", userId=" + userId + "]";
	}


	
}
