package com.pos.services;

import com.pos.model.*;


public interface DbWork {
	
	public String register(User user,UserCredentials cred) throws Exception;
	
	public UserCredentials login(UserCredentials cred);
	
}
