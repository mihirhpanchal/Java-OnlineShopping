package lti.onlineshopping.dao;

import lti.onlineshopping.model.Cart;
import lti.onlineshopping.model.CartItem;

public interface CartItemDaoIntf {

	void addCartItem(CartItem cartItem);
	void removeCartItem(String CartItemId);
	void removeAllCartItems(Cart cart);
}
