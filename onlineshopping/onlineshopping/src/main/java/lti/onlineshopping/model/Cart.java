package lti.onlineshopping.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "cart")
public class Cart {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private String cartId;

		@OneToOne
		@JoinColumn(name = "customerId")
		private Customer customer;

		@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
		private List<CartItem> cartItem;

		private double totalPrice;

		public String getCartId() {
			return cartId;
		}

		public void setCartId(String cartId) {
			this.cartId = cartId;
		}

		public List<CartItem> getCartItem() {
			return cartItem;
		}

		public void setCartItem(List<CartItem> cartItem) {
			this.cartItem = cartItem;
		}

		public double getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
		}
		
		

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public Cart() {
			super();
		}
		
		
}
