package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CenterDao;
import com.app.dao.UserDao;
import com.app.model.CenterLocation;
import com.app.model.UserRegistration;


@Service("dao_user_service")
@Transactional
public class UserServiceImp implements UserService{

	@Autowired
	UserDao dao;
	
	
	@Transactional(readOnly=true)
	@Override
	public CenterLocation centerLocation(String loc)
			throws Exception {
		
		System.out.println("in user service center method");
		return dao.centerLocation(loc);
	}
	
	
	@Override
	public UserRegistration registerCustomer(UserRegistration user)
			throws Exception {
		
		System.out.println("in user service registre method");
		return dao.userRegister(user);
	}

	@Transactional(readOnly=true)
	@Override
	public UserRegistration validateUser(String email, String pass)
			throws Exception {
		System.out.println("in user service data method");
		return dao.validateUser(email, pass);
	}
	
	@Override
	public UserRegistration updateUser(UserRegistration user) throws Exception {
		dao.updateUser(user);
		return user;
	}
	
	
	
}
