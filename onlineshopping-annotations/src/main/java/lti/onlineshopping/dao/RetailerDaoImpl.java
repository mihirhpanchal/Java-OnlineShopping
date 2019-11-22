package lti.onlineshopping.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import lti.onlineshopping.model.AdminRetailers;

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
	
public boolean insertRetailer(AdminRetailers adminretailers) {
		
		boolean res = false;
		
		try{
			em.persist(adminretailers);
			res = true;
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return res;
	
	}
	
}
	


