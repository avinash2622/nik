package com.app.dao;

import java.util.List;

import com.app.model.CenterLocation;
import com.app.model.UserRegistration;


public interface CenterDao {
	
	CenterLocation saveLocation(CenterLocation loc) throws Exception;
	CenterLocation updateCenter(CenterLocation loc) throws Exception;
	public List<CenterLocation> centerList()throws Exception;
	public List<UserRegistration> userList()throws Exception;
	public boolean deleteUser(UserRegistration u)throws Exception;
	public List<UserRegistration> getUserByCity(String city)throws Exception;
}
