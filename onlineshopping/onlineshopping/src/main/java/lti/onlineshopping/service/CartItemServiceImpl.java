package lti.onlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lti.onlineshopping.dao.CartItemDaoIntf;
import lti.onlineshopping.model.Cart;
import lti.onlineshopping.model.CartItem;
@Service("cartItemService")
public class CartItemServiceImpl implements CartServiceIntf {
	@Autowired
	private CartItemDaoIntf cartItemDao;

	public CartItemDaoIntf getCartItemDao() {
		return cartItemDao;
	}

	public void setCartItemDao(CartItemDaoIntf cartItemDao) {
		this.cartItemDao = cartItemDao;
	}

	public void addCartItem(CartItem cartItem) {
		cartItemDao.addCartItem(cartItem);

	}

	public void removeCartItem(String CartItemId) {
		cartItemDao.removeCartItem(CartItemId);
	}

	public void removeAllCartItems(Cart cart) {
		cartItemDao.removeAllCartItems(cart);
	}

	public Cart getCartByCartId(String CartId) {
		// TODO Auto-generated method stub
		return null;
	}

}
