package lti.onlineshopping.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lti.onlineshopping.model.Cart;
import lti.onlineshopping.model.MyCart;
import lti.onlineshopping.model.MyCartItem;
import lti.onlineshopping.model.OrderBack;
import lti.onlineshopping.model.OrderItemBack;

	@Controller
	@RequestMapping(value = "order")
	public class OrderController {
		
	@RequestMapping(value="/placeorder",method=RequestMethod.GET)
	public ModelAndView palceorder(HttpServletRequest request,HttpServletResponse response)
	{
	ModelAndView mav = new ModelAndView("ordersucessful");
	return mav;
	}
	
	@RequestMapping(value = "/orderconfirm", method = RequestMethod.GET)
	public ModelAndView orderconfirm(Cart cart, HttpServletRequest request) {
			HttpSession session = request.getSession();
			MyCart mycart = (MyCart)session.getAttribute("mycart"); 
			List<MyCartItem> clist = mycart.getCartItem();
			OrderBack myorder = new OrderBack();
			myorder.setOrderItem(new ArrayList<OrderItemBack>());
			 for (MyCartItem item : clist) {
				OrderItemBack orderItem = new OrderItemBack();
				orderItem.setProdid(item.getProdid());
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
