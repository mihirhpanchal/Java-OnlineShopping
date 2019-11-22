package lti.onlineshopping.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import lti.onlineshopping.model.Category;
import lti.onlineshopping.model.Product;
import lti.onlineshopping.model.SubCategory;

@Repository("productDao")
public class ProductDaoImpl implements ProductDaoIntf{
	
	@PersistenceContext
	EntityManager em;
	
	public List<Object[]> getProducts(){
		String sql="SELECT p.product_name,p.unit_price,p.product_description,p.brand,c.category_name,s.sub_name FROM Product p join Category c join SubCategory s  on p.category_id=c.category_id and p.sub_id=s.sub_id";
		sql="SELECT p.product_name,p.unit_price,p.product_description,p.brand,c.category_name,s.sub_name FROM Product p , Category c , SubCategory s  where  p.category_id=c.category_id and p.sub_id=s.sub_id";
		@SuppressWarnings("unchecked")
		List<Object[]> products = em.createNativeQuery(sql).getResultList();
		//.createQuery(sql).getResultList();
		return products;
	}

	public boolean insertProduct(Product product) {
		System.out.println("Dao called");
		boolean result = false;

		try
		{
		em.persist(product);
		result=true;
		}
		catch(Exception e)
		{
			System.out.println("Error:"+e);
		}
		return result;
	}

	public Category getCategory(String categoryname) {
		System.out.println("Category Dao called");
		Query query = em.createQuery("select  c from Category c where c.category_name=:cata");
		query.setParameter("cata", categoryname);
		
		Category category = null;
		
		try{
			category=(Category)query.getSingleResult();
		}catch (NoResultException nre){
			System.out.println(nre);
			}

			if(category == null){
			System.out.println("No category found");
			}
		
		return category;
	}

	public SubCategory getSubCategory(String scategoryname) {
		System.out.println("SubCategory Dao called");
		Query query = em.createQuery("select s from SubCategory s where s.sub_name=:scata");
		query.setParameter("scata", scategoryname);
		
		SubCategory subcategory  = null;
		try{
			subcategory =(SubCategory)query.getSingleResult();
		}catch (NoResultException nre){
			System.out.println(nre);
			}

			if(subcategory == null){
			System.out.println("No Sub category found");
			}
		
		return subcategory;
	}
	
	
}

