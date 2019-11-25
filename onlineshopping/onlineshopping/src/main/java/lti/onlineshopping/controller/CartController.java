package lti.onlineshopping.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lti.onlineshopping.model.MyCart;
import lti.onlineshopping.model.MyCartItem;
import lti.onlineshopping.model.Product;

@Controller
@RequestMapping(value = "cart")
public class CartController {
	
	@RequestMapping(value="/viewallprods",method=RequestMethod.GET)
	public ModelAndView viewallprods(HttpServletRequest request,HttpServletResponse response)
	{
	ModelAndView mav = new ModelAndView("viewallprod");
	return mav;
	}
	
	@RequestMapping(value = "/singleproduct", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request) {
		int prodid=Integer.parseInt(request.getParameter("prodid"));
		ModelAndView mav = new ModelAndView("singleproduct");
		mav.addObject("prodid",prodid);
		return mav;
	}

	
	@RequestMapping(value = "/viewmycart", method = RequestMethod.GET)
	public ModelAndView viewmycart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		MyCart mycart = (MyCart)session.getAttribute("mycart");
		
		ModelAndView mav = new ModelAndView("viewmycart");
		mav.addObject("mycart",mycart);
		return mav;
	}
	
	
	
	//addtocart.do
	
	@RequestMapping(value = "/addtocart", method = RequestMethod.POST)
	public ModelAndView addtocart(HttpServletRequest request) {
		int prodid=Integer.parseInt(request.getParameter("prodid"));
		int quantity=Integer.parseInt(request.getParameter("qty"));
		
		HttpSession session = request.getSession();
		MyCart mycart = (MyCart)session.getAttribute("mycart");
		if(mycart==null){
			System.out.println("cart not created");
			mycart = new MyCart();
			mycart.setCartItem(new ArrayList<MyCartItem>());
		}
		System.out.println(mycart);
		MyCartItem cartItem = new MyCartItem();
		cartItem.setProdid(prodid);
		cartItem.setQuantity(quantity);
		mycart.getCartItem().add(cartItem);
		session.setAttribute("mycart", mycart);
		
		System.out.println(mycart);
		ModelAndView mav = new ModelAndView("viewallprod");
		return mav;
	}
}
