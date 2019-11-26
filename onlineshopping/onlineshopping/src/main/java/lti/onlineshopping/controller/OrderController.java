package lti.onlineshopping.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import lti.onlineshopping.model.CartItem;
import lti.onlineshopping.model.MyCart;
import lti.onlineshopping.model.Order;
import lti.onlineshopping.model.OrderItem;
import lti.onlineshopping.service.OrderServiceIntf;

	@Controller
	@RequestMapping(value = "order")
	public class OrderController {
	
	@Autowired
	OrderServiceIntf orderService;
	
	
	@RequestMapping(value="/placeorder",method=RequestMethod.GET)
	public ModelAndView placeorder(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		MyCart mycart = (MyCart)session.getAttribute("mycart"); 
		List<CartItem> clist = mycart.getCartItem();
		Order myorder = new Order();
		myorder.setOrderItem((new ArrayList<OrderItem>()));
		 for (CartItem item : clist) {
			OrderItem orderItem = new OrderItem();
			orderItem.setProdid(item.getProduct_id());
			orderItem.setQuantity(item.getQuantity());
			orderItem.setPrice(item.getPrice());
			myorder.getOrderItem().add(orderItem);
		 }
		System.out.println(myorder);
		boolean flag = orderService.addOrder(myorder);
		System.out.println(flag);
		int myorderid = myorder.getOrderid();
		ModelAndView mav = new ModelAndView("ordersucessful");
		mav.addObject("myorderid",myorderid);
		return mav;
	}
	
	@RequestMapping(value = "/orderconfirm", method = RequestMethod.GET)
	public ModelAndView orderconfirm(MyCart cart, HttpServletRequest request) {
			HttpSession session = request.getSession();
			MyCart mycart = (MyCart)session.getAttribute("mycart"); 
			List<CartItem> clist = mycart.getCartItem();
			Order myorder = new Order();
			myorder.setOrderItem(new ArrayList<OrderItem>());
			 for (CartItem item : clist) {
				OrderItem orderItem = new OrderItem();
				orderItem.setProdid(item.getProduct_id());
				orderItem.setQuantity(item.getQuantity());
				orderItem.setPrice(item.getPrice());
				myorder.getOrderItem().add(orderItem);
			 }
			System.out.println(myorder);
			ModelAndView mav = new ModelAndView("orderconfirm");
			mav.addObject("myorder",myorder);
			return mav;
		}
		
	
}
