package lti.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lti.onlineshopping.dao.ProductDaoIntf;
import lti.onlineshopping.model.Category;
import lti.onlineshopping.model.Product;
import lti.onlineshopping.model.SubCategory;

@Service("productService")
public class ProductServiceImpl implements ProductServiceIntf {

	@Autowired
	ProductDaoIntf productDao;
	
	@Transactional
	public boolean insertProduct(Product product) {
		System.out.println("Service is called");
		boolean flag=productDao.insertProduct(product);
		
		return flag;
	}

	@Transactional
	public Category getCategory(String categoryname){
		System.out.println("Category service is called");
		Category c =productDao.getCategory(categoryname);
		return c;
	}

	@Transactional
	public SubCategory getSubCategory(String scategoryname) {
		System.out.println("Category service is called");
		SubCategory s =productDao.getSubCategory(scategoryname);
		return s;
	}
	
	@Transactional
	public List<Object[]> getUsers() {
		List<Object[]> list = productDao.getProducts();
		return list;
	}
	
	@Transactional
	public List<Product> searchKeywords(String search){
		System.out.println("Search service called");
		return  productDao.searchKeywords(search);

	}
	
}
