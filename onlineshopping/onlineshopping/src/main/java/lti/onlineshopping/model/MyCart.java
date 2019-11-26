package lti.onlineshopping.model;

import java.util.List;

public class MyCart {

	private List<CartItem> cartItem;

	public List<CartItem> getCartItem() {
		return cartItem ;
	}

	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}

	@Override
	public String toString() {
		return "MyCart [cartItem=" + cartItem + "]";
	}

	
	
	
}
