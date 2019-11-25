package lti.onlineshopping.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class MyCart {

	private List<MyCartItem> cartItem;

	public List<MyCartItem> getCartItem() {
		return cartItem ;
	}

	public void setCartItem(List<MyCartItem> cartItem) {
		this.cartItem = cartItem;
	}

	@Override
	public String toString() {
		return "MyCart [cartItem=" + cartItem + "]";
	}

	
	
	
}
