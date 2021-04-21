package com.pos.model;

public class UserCredentials {

	private String userId;
	private char userType;
	private String password;
	
	public UserCredentials()
	{
		
	}
	
	public UserCredentials(String userId, char userType, String password) {
		super();
		this.userId = userId;
		this.userType = userType;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
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
	
}
