package lti.onlineshopping.dao;

import java.util.List;

import lti.onlineshopping.model.Category;
import lti.onlineshopping.model.Product;
import lti.onlineshopping.model.SubCategory;

public interface DaoIntf {
	
	public boolean insertProduct(Product product);
	
	public Category getCategory(String categoryname);
	
	public SubCategory getSubCategory(String scategoryname);
	
	public List<Object[]> getProducts();
}
