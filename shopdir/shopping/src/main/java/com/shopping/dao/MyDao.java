package com.shopping.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import org.springframework.stereotype.Repository;

import com.shopping.model.User;

@Repository("myDao")
public class MyDao {

	public static boolean insertUser(User user) {

		boolean res = false;
		
		try{
			System.out.println("Dao called");
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			res = true;
			em.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return res;
	}
	
	public User validateUser(User user) {
	    
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		User f =null;
		try{
			f=(User)em.createQuery("SELECT f FROM User f WHERE f.username=:username and f.password=:password")
		         .setParameter("username", user.getUsername())
		         .setParameter("password",user.getPassword())
		         .getSingleResult();
		}
		catch(Exception e) {System.out.println(e); }
		em.close();
		System.out.println(f);
		return f;
	  }

}
