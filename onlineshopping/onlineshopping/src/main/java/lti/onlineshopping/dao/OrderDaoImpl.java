package lti.onlineshopping.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import lti.onlineshopping.model.Order;
@Repository("orderDao")
public class OrderDaoImpl implements OrderDaoIntf {

	@PersistenceContext
	EntityManager em;
	
	public boolean addOrder(Order order) {
		System.out.println("Order Dao called");
		boolean result = false;
		try
		{
		em.persist(order);
		result=true;
		}
		catch(Exception e)
		{
			System.out.println("Error:"+e);
		}
		return result;
	}
}
