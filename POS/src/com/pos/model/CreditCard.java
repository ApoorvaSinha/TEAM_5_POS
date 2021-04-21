package com.pos.model;

public class CreditCard {

	private String CrediCardNumber;
	private String ValidFrom;
	private String ValidTo;
	private int Balance;
	private String userId;
	
	
	public CreditCard(String crediCardNumber, String validFrom, String validTo,
			int balance, String userId) {
		super();
		CrediCardNumber = crediCardNumber;
		ValidFrom = validFrom;
		ValidTo = validTo;
		Balance = balance;
		this.userId = userId;
	}


	public String getCrediCardNumber() {
		return CrediCardNumber;
	}


	public void setCrediCardNumber(String crediCardNumber) {
		CrediCardNumber = crediCardNumber;
	}


	public String getValidFrom() {
		return ValidFrom;
	}


	public void setValidFrom(String validFrom) {
		ValidFrom = validFrom;
	}


	public String getValidTo() {
		return ValidTo;
	}


	public void setValidTo(String validTo) {
		ValidTo = validTo;
	}


	public int getBalance() {
		return Balance;
	}


	public void setBalance(int balance) {
		Balance = balance;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
	

}
