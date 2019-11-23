package lti.onlineshopping.model;

import java.io.Serializable;
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


		private static final long serialVersionUID = 8436097833452420298L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private String cartId;

		@OneToOne
		@JoinColumn(name = "customerId")
		private User customer;

		@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
		private List<CartItem> cartItem;

		private double totalPrice;
}
