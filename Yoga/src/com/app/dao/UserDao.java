package com.app.dao;

import java.util.List;

import com.app.model.CenterLocation;
import com.app.model.UserRegistration;

public interface UserDao {

	public CenterLocation centerLocation(String em)throws Exception;
	public UserRegistration userRegister(UserRegistration user)throws Exception;
	public UserRegistration validateUser(String em, String pass)throws Exception;
	public UserRegistration updateUser(UserRegistration user) throws Exception;
	public UserRegistration getUser(UserRegistration user) throws Exception;

}
