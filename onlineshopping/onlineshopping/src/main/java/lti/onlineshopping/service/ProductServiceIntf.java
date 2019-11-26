package lti.onlineshopping.service;

import java.util.List;

import lti.onlineshopping.model.Category;
import lti.onlineshopping.model.Product;
import lti.onlineshopping.model.SubCategory;

public interface ProductServiceIntf {
	
	public boolean insertProduct(Product product);
	
	public Category getCategory(String categoryname);
	
	public SubCategory getSubCategory(String scategoryname);
	
	public List<Object[]> getProducts();
	
	public List<Object[]> getmyProducts();
	
	public Product  fetchDetails(int prodid);
	
	public Product compareProduct(int prodid);
	
	public List<Product> searchKeywords(String search);
	
	public boolean removeProduct(int prodid);
	
}
