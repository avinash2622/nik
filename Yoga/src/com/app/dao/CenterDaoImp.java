package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.model.CenterLocation;
import com.app.model.UserRegistration;


@Repository
public class CenterDaoImp implements CenterDao{

	
	
	@Autowired
	private SessionFactory factory;
	
	@Override
	public CenterLocation saveLocation(CenterLocation loc) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Inside dao layer saveLocation method");
		factory.getCurrentSession().save(loc);
		
		return loc;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CenterLocation> centerList()
	{
		return factory.getCurrentSession().createQuery(
				"select c from CenterLocation c").list();
	}
	
	@Override
	public CenterLocation updateCenter(CenterLocation loc) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Inside the DAO layer update method");
		factory.getCurrentSession().update(loc);
		return loc;
		
	}	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserRegistration> userList()throws Exception
	{
		return factory.getCurrentSession().createQuery(
				"select u from UserRegistration u").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<UserRegistration> getUserByCity(String city)throws Exception
	{
		return (List<UserRegistration>)factory.getCurrentSession().createQuery(
				"select u from UserRegistration u where u.centerLocation.centerAddress =:city").
				setParameter("city",city).list();
	}
	
	@Override
	public boolean deleteUser(UserRegistration u) throws Exception {
		factory.getCurrentSession().delete(u);
		return true;
	}
	
}
