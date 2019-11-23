package lti.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lti.onlineshopping.dao.OrderDaoIntf;
import lti.onlineshopping.model.Cart;
import lti.onlineshopping.model.CartItem;
import lti.onlineshopping.model.CustomerOrder;
@Service("orderService")
public class OrderServiceImpl implements OrderServiceIntf {


	@Autowired
	private OrderDaoIntf customerOrderDao;
	
	@Autowired
	private CartServiceIntf cartService;
	
	public void addCustomerOrder(CustomerOrder customerOrder) {
		customerOrderDao.addCustomerOrder(customerOrder);
	}

	public double getCustomerOrderGrandTotal(String cartId) {
		double grandTotal=0;
		Cart cart = cartService.getCartByCartId(cartId);
		List<CartItem> cartItems = cart.getCartItem();
		
		for(CartItem item: cartItems){
			grandTotal += item.getPrice();
		}
		return grandTotal;
	}

}
