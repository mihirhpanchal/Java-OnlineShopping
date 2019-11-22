package lti.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lti.onlineshopping.model.AdminRetailers;

import lti.onlineshopping.model.Retailer;
import lti.onlineshopping.model.User;
import lti.onlineshopping.service.RetailerServiceInt;



@Controller("mycontroller")
public class AdminController {
	
	@Autowired
	 public RetailerServiceInt retailerService;
	
	@RequestMapping(value = "/viewretailers", method = RequestMethod.GET)
	public ModelAndView viewretailers(){
		 List<Retailer>  retailer = retailerService. getRetailers();
		 ModelAndView mav = new ModelAndView("viewretailers");
		 mav.addObject("retailerlist",retailer);
		 return mav;
		
	}

	@RequestMapping(value = "/removeretailer", method = RequestMethod.GET)
	public ModelAndView removeRetailer( HttpServletRequest request,HttpServletResponse response){
		/*Retailer retailer1 = retailerService.removeRetailer(retailer);
		ModelAndView mav = new ModelAndView("deletedretailers");
		return mav;*/
		String retailerid= request.getParameter("id");
		boolean flag = retailerService.removeRetailer(retailerid);
		System.out.println("god");
		ModelAndView mav = new ModelAndView("deletedretailers");
		mav.addObject("flag",flag);
		 return mav;
		}
		
	@RequestMapping(value="/addretailers", method=RequestMethod.GET)
	public ModelAndView insertRetailer1(){
		ModelAndView mav = new ModelAndView("addretailers");
		return mav;
	}
	
	@RequestMapping(value="/addretailers", method=RequestMethod.POST)
	public ModelAndView insertRetailer(@ModelAttribute AdminRetailers adminretailers ){
		
		/*String retailername = request.getParameter("retailername");
		String email = request.getParameter("email");
		String mobileno = request.getParameter("mobileno");
		
		AdminRetailers adminretailers = new AdminRetailers();
		adminretailers.setRetailername(retailername);
		adminretailers.setEmail(email);
		adminretailers.setMobile_no(mobileno);
		System.out.println(adminretailers);*/
		
		System.out.println(adminretailers);
		boolean flag = retailerService.insertRetailer(adminretailers);
		System.out.println("flag="+flag);
		
		if(flag){
			ModelAndView mav = new ModelAndView("success");
			mav.addObject("success", new  AdminRetailers());
			mav.addObject("status", "Registration successful");
			return mav;
		}
		else{
			ModelAndView mav = new ModelAndView("addretailers");
			mav.addObject("addretailers", new AdminRetailers());
			mav.addObject("status", "Retailer already present");
			return mav;
		}
	}
	
}
