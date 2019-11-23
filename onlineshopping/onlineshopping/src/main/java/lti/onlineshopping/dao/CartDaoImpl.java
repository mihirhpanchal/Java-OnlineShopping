package lti.onlineshopping.dao;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lti.onlineshopping.model.Cart;
import lti.onlineshopping.service.OrderServiceIntf;
@Repository("cartDao")
public class CartDaoImpl {


	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private OrderServiceIntf customerOrderService;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Cart getCartByCartId(String CartId) {
		Session session = sessionFactory.openSession();
		Cart cart = (Cart) session.get(Cart.class, CartId);
		System.out.println(cart.getCartId() + " " + cart.getCartItem());
		System.out.println(cart);
		session.close();
		return cart;

	}

	public Cart validate(String cartId) throws IOException {
		Cart cart = getCartByCartId(cartId);
		if (cart == null || cart.getCartItem().size() == 0) {
			throw new IOException(cartId + "");
		}
		update(cart);
		return cart;
	}

	public void update(Cart cart) {

		String cartId = cart.getCartId();
		double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
		cart.setTotalPrice(grandTotal);

		Session session = sessionFactory.openSession();
		session.saveOrUpdate(cart);
		session.flush();
		session.close();
	}
}
