package lti.onlineshopping.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import lti.onlineshopping.model.User;


@Repository("userDao")
public class UserDaoImpl implements UserDaoIntf{
	
	@PersistenceContext
	EntityManager em;

	public boolean insertUser(User user) {

		boolean res = false;
		
		try{
			System.out.println("Dao called");
			em.persist(user);
		
			res = true;
	
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return res;
	}
	
	public User validateUser(User user) {
	    
		User f =null;
		try{
			f=(User)em.createQuery("SELECT f FROM User f WHERE f.username=:username and f.password=:password")
		         .setParameter("username", user.getUsername())
		         .setParameter("password",user.getPassword())
		         .getSingleResult();
		}
		catch(Exception e) {System.out.println(e); }
	
		System.out.println(f);
		return f;
	  }

}
