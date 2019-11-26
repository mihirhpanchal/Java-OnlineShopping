package lti.onlineshopping.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import lti.onlineshopping.model.Retailer;

@Repository("retailerDao")
public class RetailerDaoImpl implements RetailerDaoIntf{
	
	@PersistenceContext
	EntityManager em;
	
	public List<Retailer> getRetailers(){
		  
			  @SuppressWarnings("unchecked")
				List<Retailer> retailer = em.createQuery("SELECT u FROM  Retailer u").getResultList();
			  return  retailer;
			  }
	
	
	public boolean removeRetailer(String id){
		boolean flag=false;
		  Retailer re= em.find(Retailer.class,id);
		  if(re!=null){
		  em.remove(re);
		  flag=true;
		  }
		  return flag;
	
	}
}