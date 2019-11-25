package lti.onlineshopping.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import lti.onlineshopping.model.Order;
import lti.onlineshopping.model.OrderBack;
@Repository("orderDao")
public class OrderDaoImpl implements OrderDaoIntf {

	public boolean addOrder(Order order) {
		System.out.println("Order Dao called");
		boolean result = false;

		try
		{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();	
		result=true;
		}
		catch(Exception e)
		{
			System.out.println("Error:"+e);
		}
		return result;
	}
}
