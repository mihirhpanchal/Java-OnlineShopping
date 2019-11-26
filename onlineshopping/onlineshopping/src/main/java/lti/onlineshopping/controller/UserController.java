package lti.onlineshopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lti.onlineshopping.model.User;
import lti.onlineshopping.service.UserServiceIntf;


@Controller("userController")
public class UserController {

	@Autowired
	private UserServiceIntf userService;
	
   @RequestMapping(value = "/signup", method=RequestMethod.GET)
	public ModelAndView getSignUpPage() {
		
		ModelAndView mav = new ModelAndView("signup");
		return mav;
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
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
		
		boolean flag = userService.insertUser(user);
		
		if(flag){
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("login", new User());
			mav.addObject("status", "Registration successful");
			mav.addObject("status1", "Please Login to continue");
			return mav;
		}
		else{
			ModelAndView mav = new ModelAndView("signup");
			mav.addObject("signup", new User());
			mav.addObject("status", "User already present");
			return mav;
		}
	}
	
	@RequestMapping(value = "/loginProcess", method=RequestMethod.GET)
	public ModelAndView getLoginPage() {
		
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping(value = "/loginProcess", method= RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,   @ModelAttribute("users") User iuser) {
		System.out.println("Controller called");
	    ModelAndView mav = null;
	    User user = userService.validateUser(iuser);
	    if (user != null) {
	      mav = new ModelAndView("redirect:/index.jsp");
	     /* mav.addObject("username", user.getUsername());*/
	      //session manage
	      HttpSession session= request.getSession();
	      session.setAttribute("username", iuser.getUsername());
	    } 
	    else {
	      mav = new ModelAndView("login");
	      mav.addObject("message", "Username or Password is wrong!!");
	    }
	    return mav;
	  }
	
	
	@RequestMapping(value = "/logoutProcess", method= RequestMethod.GET)
	  public ModelAndView logoutProcess(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		System.out.println(session.getAttribute("username"));
		HttpSession session1 =request.getSession(false);
		session1.invalidate();
		ModelAndView mav = new ModelAndView("redirect:/index.jsp");
		return mav;
	}
	
}