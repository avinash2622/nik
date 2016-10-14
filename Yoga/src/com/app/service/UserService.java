package com.app.service;

import java.util.List;

import com.app.model.CenterLocation;
import com.app.model.UserRegistration;

public interface UserService {

	public CenterLocation centerLocation(String email)throws Exception;
	public UserRegistration registerCustomer(UserRegistration user)throws Exception;
	public UserRegistration validateUser(String email, String pass)throws Exception;
	public UserRegistration updateUser(UserRegistration user) throws Exception;
	
}
