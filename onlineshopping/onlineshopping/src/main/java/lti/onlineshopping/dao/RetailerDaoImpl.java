package lti.onlineshopping.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import lti.onlineshopping.model.Retailer;





@Repository("retailerDao")
public class RetailerDaoImpl implements RetailerDaoIntf{
	
	public List<Retailer> getRetailers(){
		
			  EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
			  EntityManager em = emf.createEntityManager();	  
			  @SuppressWarnings("unchecked")
				List<Retailer> retailer = em.createQuery("SELECT u FROM  Retailer u").getResultList();
			  return  retailer;
			  }
	
	
	public boolean removeRetailer(String id){
		boolean flag=false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		  EntityManager em = emf.createEntityManager();	  
		  EntityTransaction t = em.getTransaction();
		  t.begin();
		  Retailer re= em.find(Retailer.class,id);
		  if(re!=null){
		  em.remove(re);
		  t.commit();
		  flag=true;
		  }
		 em.close();
		  return flag;
	
	}
	}
	


