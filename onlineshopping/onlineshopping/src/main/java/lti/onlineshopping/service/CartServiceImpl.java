package lti.onlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lti.onlineshopping.dao.CartDaoIntf;
import lti.onlineshopping.model.Cart;
@Service("cartService")
public class CartServiceImpl implements CartServiceIntf {


	@Autowired
	private CartDaoIntf cartDao;

	public CartDaoIntf getCartDao() {
		return cartDao;
	}

	public void setCartDao(CartDaoIntf cartDao) {
		this.cartDao = cartDao;
	}

	public Cart getCartByCartId(String CartId) {

		return cartDao.getCartByCartId(CartId);
	}
}
