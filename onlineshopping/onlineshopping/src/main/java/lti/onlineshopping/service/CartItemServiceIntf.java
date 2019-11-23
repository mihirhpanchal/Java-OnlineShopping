package lti.onlineshopping.service;

import lti.onlineshopping.model.Cart;
import lti.onlineshopping.model.CartItem;

public interface CartItemServiceIntf {


	void addCartItem(CartItem cartItem);
	void removeCartItem(String CartItemId);
	void removeAllCartItems(Cart cart);
}
