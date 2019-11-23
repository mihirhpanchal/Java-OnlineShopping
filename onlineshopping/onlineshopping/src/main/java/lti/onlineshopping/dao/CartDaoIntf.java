package lti.onlineshopping.dao;

import java.io.IOException;

import lti.onlineshopping.model.Cart;


public interface CartDaoIntf {

	Cart getCartByCartId(String CartId);
	
	Cart validate(String cartId) throws IOException;
	
	void update(Cart cart);
}
