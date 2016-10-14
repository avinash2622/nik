package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CenterDao;
import com.app.dao.UserDao;
import com.app.model.CenterLocation;
import com.app.model.UserRegistration;



@Service("dao_center_service")
@Transactional
public class CenterServiceImp implements CenterService{

	
	@Autowired
	CenterDao cdao;
	
	@Override
	public CenterLocation saveLocation(CenterLocation loc)
			throws Exception {
		
		/*System.out.println("in service");
		String a[] = user.getUserRegEmail().split(",");
		String b[] = user.getUserRegAddress().split(",");
		user.setUserRegEmail(a[0]);
		user.setUserRegPass(b[0]);*/
		System.out.println("in service layer "+ loc);
		return cdao.saveLocation(loc);
	}
	
	
	@Override
	public CenterLocation updateCenter(CenterLocation loc) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Inside service layer ");
		cdao.updateCenter(loc);
		return loc;
	}

	@Override
	public List<CenterLocation> centerList() throws Exception {
	
		return cdao.centerList();
	}

	@Override
	public List<UserRegistration> userList() throws Exception {
	
		return cdao.userList();
	}


	@Override
	public boolean deleteUser(UserRegistration u) throws Exception {
		
		return cdao.deleteUser(u);
	}
	@Override
	public List<UserRegistration> getUserByCity(String city)throws Exception
	{
		return cdao.getUserByCity(city);
	}
}
