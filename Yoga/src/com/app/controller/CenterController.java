package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.CenterLocation;
import com.app.model.UserRegistration;
import com.app.service.CenterService;

@Controller
public class CenterController {
	
	@Autowired
	//@Qualifier("dao_center_service")
	private CenterService cs;
	

	
	@RequestMapping("/center")
	public ModelAndView centerLocation(@ModelAttribute("center1") CenterLocation ncenter) throws Exception{
		
			ModelAndView model= new ModelAndView("successCenter");
			model.addObject("msg","Hello ADMIN");
	
			cs.saveLocation(ncenter);
			
		return model;
		
	}
	
	//getting the list of center
	@RequestMapping(value="/centerPage")
	public String centerPage(HttpSession hs)
	{
	
		try {
			List<CenterLocation> clist = cs.centerList();
			System.out.println("inside center " + clist);
			hs.setAttribute("centList", clist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "centerPage";
	}
	
	@RequestMapping(value="/deleteUser")
	public String deleteUser(HttpSession hs,HttpServletRequest req)
	{
		Integer id = null;
		if(req.getParameter("deleteId") != null)
		id = Integer.parseInt(req.getParameter("deleteId"));
		System.out.println("inside center id "+id);
		UserRegistration u= new UserRegistration();
		u.setUserRegId(id);
		try {
			cs.deleteUser(u);
			System.out.println("inside center ");
			List<UserRegistration> ulist = (List<UserRegistration>)hs.getAttribute("userList");
			ulist.remove(u);
			System.out.println("inside center list "+ulist);
			hs.setAttribute("userList",ulist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "userList";
	}
	
	
	@RequestMapping(value="/userList")
	public String userList(HttpSession hs,HttpServletRequest req)
	{
		System.out.println("hello");
		String city = req.getParameter("selectCity");
		System.out.println("city "+city);
		List<UserRegistration> ulist;
		try {
			if(city == null || city.equals("all") )
			{
				System.out.println(" in if ");
			 ulist = cs.userList();
			
			}
			else
			{
				System.out.println(" in else");
				 ulist = cs.getUserByCity(city);
			}
			System.out.println("inside center printint user list" + ulist);
			hs.setAttribute("userList", ulist);
			
			List<CenterLocation> clist= cs.centerList();
			System.out.println("inside center printing center list" + ulist);
			hs.setAttribute("centerList", clist);
									//here selectCity is the name of the input in the jsp page
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return "userList";
	}
	
	
	
	//adding new center in the center list
	@RequestMapping(value="/addCenter")
	public String saveNewCenter(CenterLocation cl, HttpSession hs)
	{
		try {
			cs.saveLocation(cl);
			@SuppressWarnings("unchecked")				//this centlist is defined in centerPage.jsp
			List<CenterLocation> clist=( List<CenterLocation>) hs.getAttribute("centList");
			clist.add(cl);
			hs.setAttribute("centList", clist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "centerPage";
	}
	
	


}
