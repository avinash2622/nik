package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.model.CenterLocation;
import com.app.model.UserRegistration;

@Repository
public class UserDaoImp implements UserDao{

	@Autowired
	private SessionFactory factory;
	
	
	@Override
	public CenterLocation centerLocation(String loc)
			throws Exception {
		System.out.println("in DAO center");
		return (CenterLocation) factory
				.getCurrentSession()
				.createQuery(
						"select c from CenterLocation c where c.centerAddress = :loc")
				.setParameter("loc", loc).uniqueResult();
	}
	
	
	@Override
	public UserRegistration userRegister(UserRegistration user)
			throws Exception {
		System.out.println("in dao user");
		System.out.println(user);
		factory.getCurrentSession().save(user);
		return user;
	}

	@Override
	public UserRegistration validateUser(String em, String pass)
			throws Exception {
		return (UserRegistration) factory
				.getCurrentSession()
				.createQuery(
						"select c from UserRegistration c where c.userRegEmail= :em and c.userRegPass = :pass")
				.setParameter("em", em).setParameter("pass", pass)
				.uniqueResult();
	}
	
	@Override
	public UserRegistration updateUser(UserRegistration user) throws Exception {
		factory.getCurrentSession().update(user);
		return user;
	}


	@Override
	public UserRegistration getUser(UserRegistration user) throws Exception {
		return (UserRegistration) factory
				.getCurrentSession().get(UserRegistration.class,user.getUserRegId());
				
				
	}
	
	
	
}
