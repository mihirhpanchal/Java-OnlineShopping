package lti.onlineshopping.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import lti.onlineshopping.model.Category;
import lti.onlineshopping.model.Order;
import lti.onlineshopping.model.Product;
import lti.onlineshopping.model.Retailer;
import lti.onlineshopping.model.SubCategory;

@Repository("productDao")
public class ProductDaoImpl implements ProductDaoIntf{


	
	public List<Object[]> getProducts(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		String sql=null;
		sql="SELECT p.product_id,p.product_name,p.unit_price,p.product_description,p.brand,c.category_name,s.sub_name,p.filename FROM Product p , Category c , SubCategory s  where  p.category_id=c.category_id and p.sub_id=s.sub_id";
		@SuppressWarnings("unchecked")
		List<Object[]> products = em.createNativeQuery(sql).getResultList();
		//.createQuery(sql).getResultList();
		em.close();
		emf.close();
		return products;
	}

	public boolean insertProduct(Product product) {
		boolean result = false;
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try
		{
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();	
		result=true;
		}
		catch(Exception e)
		{
			System.out.println("Error:"+e);
		}finally{
		em.close();
		emf.close();
		}return result;
	}

	public Category getCategory(String categoryname) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
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
		em.close();
		emf.close();
		return category;
	}

	public SubCategory getSubCategory(String scategoryname) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
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
		em.close();
		emf.close();
		return subcategory;
	}
	
	public Product fetchDetails(int prodid){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select p from Product p where p.product_id=:prodid");
		query.setParameter("prodid", prodid);
		
		Product	product =(Product)query.getSingleResult();

		
		return product;
		}
	
		public Product compareProduct(int prodid) {
		
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
			EntityManager em = emf.createEntityManager();
		
			Query query = em.createQuery("SELECT p FROM Product p where p.product_id=:prodid");
			query.setParameter("prodid", prodid);
			Product products = (Product) query.getSingleResult();
			return products;
		
		}
	
		@SuppressWarnings("unchecked")
		public List<Product> searchKeywords(String search){
		
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
			EntityManager em = emf.createEntityManager();
			Query query = em.createQuery("SELECT p FROM Product p  WHERE (0 < LOCATE(:searchStr,  p.product_name||p.product_description||p.brand))");
			query.setParameter("searchStr", search);
			List<Product> searchList = query.getResultList();
			return searchList;
		}
		

			public boolean makePayment(Order order){
				boolean flag = false;
				EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("pu");
				EntityManager em1 = emf1.createEntityManager();
				
				try{
					em1.getTransaction().begin();
					em1.persist(order);
					em1.getTransaction().commit();
					em1.close();
					flag = true;
					
				}
				catch(Exception e){
					System.out.println("Error"+e);
				}
					return flag;
				
			}
			
		
		public boolean removeProduct(int id){
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
			EntityManager em = emf.createEntityManager();
			
			boolean flag=false;
			em.getTransaction().begin();
			Query query = em.createQuery("DELETE FROM Product p WHERE p.product_id = :pid ");
			query.setParameter("pid", id);
			int rowsDeleted = query.executeUpdate();
			em.getTransaction().commit();
			em.close();
			emf.close();
			flag=true;
			return flag;
		
		}
		
}

