package com.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.model.User;
import com.shopping.service.UserService;

@Controller("myController")
public class UserController {

	@Autowired
	private UserService myService;
	
	@RequestMapping(value="/signup", method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView insertUser(HttpServletRequest request, HttpServletResponse response){
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String cno = request.getParameter("cno");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setCno(cno);
		
		boolean flag = myService.insertUser(user);
		
		if(flag){
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("login", new User());
			mav.addObject("status", "Registration successful");
			return mav;
		}
		else{
			ModelAndView mav = new ModelAndView("signup");
			mav.addObject("signup", new User());
			mav.addObject("status", "User already present");
			return mav;
		}
	}
	
	@RequestMapping(value = "/loginProcess", method = RequestMethod.GET)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,   @ModelAttribute User iuser) {
	    ModelAndView mav = null;
	    User user = myService.validateUser(iuser);
	    if (user != null) {
	      mav = new ModelAndView("welcome");
	      mav.addObject("username", user.getUsername());
	      //session manage
	      HttpSession session= request.getSession();
	      session.setAttribute("username", iuser.getUsername());
	    } else {
	      mav = new ModelAndView("login");
	      mav.addObject("message", "Username or Password is wrong!!");
	    }
	    return mav;
	  }
	
}