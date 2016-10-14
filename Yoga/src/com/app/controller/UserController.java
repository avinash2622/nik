package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.CenterLocation;
import com.app.model.UserRegistration;
import com.app.service.CenterService;
import com.app.service.UserService;

@Controller
//@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	@Qualifier("dao_user_service")
	private UserService us;
	
	@Autowired
	private CenterService cs;
	
	
	@RequestMapping(value="/home")
	public String homePage(Model model)
	{
		model.addAttribute("signinModel",new UserRegistration());
		return "home";
	}
	
	@RequestMapping(value="/registerPage")
	public String registerPage(HttpSession hs)
	{
		List<CenterLocation> clist =null;
		try {
			clist = cs.centerList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("inside center printing center list" + clist);
		hs.setAttribute("centerList", clist);
		return "register";
	}
	
	@RequestMapping(value="/successPage")
	public String successPage()
	{
		//model.addAttribute("signinModel",new UserRegistration());
		return "success";
	}

	
	
	
	
	@RequestMapping(value="/signIn")
	public String signIn(UserRegistration user,HttpSession hs)
	{

		System.out.println("Inside UserController signIn method" + user);
		
		//us.validateUser(user);
		if(user.getUserRegEmail().equals("admin@gmail.com") && user.getUserRegPass().equals("admin123"))
			return "adminPage";
		
		try {
			UserRegistration validUser = us.validateUser(user.getUserRegEmail(),user.getUserRegPass());
			if(validUser != null)
			{
			hs.setAttribute("validUser",validUser);
			System.out.println("session "+hs.getAttribute("validUser"));
			return "userDetails";
			}
			return "home";
		} catch (Exception e) {
			
			return "home";
		}
		
					
		
	}
	
	
	@RequestMapping(value ="/reg" , method=RequestMethod.POST)
	public String processRegisterForm(UserRegistration u,Model map,HttpServletRequest req,HttpSession hs)
	{
		//map.addAttribute("userRegistration1", new UserRegistration());
		System.out.println("in process login form " + u);
			
			boolean flag= false;					
				
		//	String location = req.getParameter("location");
			if(u.getUserRegFullname().length()==0)
			{
				
				map.addAttribute("uname", "please enter the name");
				flag=true;
			}
			if(u.getUserRegEmail().length()==0)
			{
				map.addAttribute("email","please enter the email");
			}
			else{
				java.util.regex.Pattern p = java.util.regex.Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
				
				java.util.regex.Matcher m = p.matcher(u.getUserRegEmail());
				
				if(!m.find())
				{
					map.addAttribute("email","incorrect email");
					flag= true;
				}
			}
			if(u.getUserRegPass().length()<6)
			{
				map.addAttribute("password","length should not be less than 6");
			}
			
			if(u.getUserRegPhone().length()!=10)
			{
				map.addAttribute("phone","incorrect phone number");
			}
			if(u.getUserRegAddress().length()==0)
			{
				map.addAttribute("userAddress","please enter the user address");
			}
			
				
			if(!flag)
			{
			try {
				CenterLocation cl = us.centerLocation(u.getCenterLocation().getCenterAddress());
				System.out.println("in user controller 1 method" +cl);
				u.setCenterLocation(cl);
				
				us.registerCustomer(u);
				
				System.out.println("in user controller 2 method" +us);
				
				map.addAttribute("valid_contact", u);
				hs.setAttribute("validUser", u);
			}
				catch (Exception e) 
				{
					System.out.println("err in reg controller " + e);
					e.printStackTrace();
					return "register";
				}
		
			return "userDetails";
			}
			
			return "register";
	}
	
	@RequestMapping(value="/update")
	public String updateUser(UserRegistration user, HttpSession hs, HttpServletRequest req) {
		
		String loc = req.getParameter("location");
		UserRegistration userv = (UserRegistration)hs.getAttribute("validUser");
		user.setUserRegId(userv.getUserRegId());
		try {
			   
			System.out.println("in user controller update 1 method user" +user);
			CenterLocation cl = us.centerLocation(loc);
			System.out.println("in user controller update 1 method" +cl);
			user.setCenterLocation(cl);
			
			System.out.println("in user controller update in b/t method" +cl);
			us.updateUser(user);
			
			System.out.println("in user controller update 2 method user"+user);
			
			hs.setAttribute("validUser", user);
		}
			catch (Exception e) 
			{
				System.out.println("err in update controller " + e);
				e.printStackTrace();
				
			}
		return "userDetails";
	}
	
	
	
	@RequestMapping(value ="/logout")
	public String logout(HttpSession hs)
	{
		hs.invalidate();
		
		return "home";
		
	}

}
