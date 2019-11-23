package lti.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lti.onlineshopping.model.Cart;
import lti.onlineshopping.model.Customer;
import lti.onlineshopping.model.User;
import lti.onlineshopping.service.CartServiceIntf;
import lti.onlineshopping.service.CustomerServiceIntf;

@Controller("cartController")
public class CartController {


	@Autowired
	private CustomerServiceIntf customerService;
	
	@Autowired
	private CartServiceIntf cartService;

	public CustomerServiceIntf getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerServiceIntf customerService) {
		this.customerService = customerService;
	}

	public CartServiceIntf getCartService() {
		return cartService;
	}

	public void setCartService(CartServiceIntf cartService) {
		this.cartService = cartService;
	}
	
	@RequestMapping("cart/getCartById")
	public String getCartId(Model model){
		
		//User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = new User();
		String emailId = user.getUsername();
		Customer customer = customerService.getCustomerByemailId(emailId);
		model.addAttribute("cartId", customer.getCart().getCartId());
		return "cart";
	}
	
	@RequestMapping("/cart/getCart/{cartId}")
	public @ResponseBody Cart getCartItems(@PathVariable(value="cartId")String cartId){
		return cartService.getCartByCartId(cartId);
	}
}
