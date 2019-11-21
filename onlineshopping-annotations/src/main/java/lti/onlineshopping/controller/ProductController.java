package lti.onlineshopping.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lti.onlineshopping.model.Category;
import lti.onlineshopping.model.Product;
import lti.onlineshopping.model.SubCategory;
import lti.onlineshopping.service.ProductServiceIntf;
  
@Controller("productController")
public class ProductController {
	@Autowired
	ProductServiceIntf productService;
	@RequestMapping(value="/insertproduct",method=RequestMethod.POST)
	public ModelAndView insertContact(HttpServletRequest request,HttpServletResponse response)
	{
		String product_name=request.getParameter("product_name");
		String brand=request.getParameter("brand");
		String product_description=request.getParameter("product_description");
		String unit_price=request.getParameter("unit_price");
		String quantity=request.getParameter("quantity");
		String categoryname=request.getParameter("category");
		String subcategoryname=request.getParameter("subcategory");
		
		Category category = productService.getCategory(categoryname);
		String cid = category.getCategory_id();

		SubCategory subcategory = productService.getSubCategory(subcategoryname);
		String sid = subcategory.getSub_id();
		
		Calendar cal = Calendar.getInstance();
	    Date date=cal.getTime();
		System.out.println(date);
		
		
		Product product=new Product();
		product.setProduct_name(product_name);
		product.setBrand(brand);
		product.setProduct_description(product_description);
		product.setUnit_price(unit_price);
		product.setCategory(category);
		product.setSubcategory(subcategory);
		product.setQuantity(quantity);
		product.setDate_added(date);
		
		
		boolean flag= productService.insertProduct(product);
		ModelAndView mav=new ModelAndView();
		mav.addObject("product_name",product_name);
		mav.addObject("product_description",product_description);
		mav.addObject("unit_price",unit_price);
		mav.addObject("quantity",quantity);
		mav.addObject("category_id",cid);
		mav.addObject("sub_id",sid);
		mav.addObject(date);
		if(flag)
		{
			mav.addObject("status","Thanks msg is accepted");
		}else{
			mav.addObject("status","sorry msg is not accepted");
		}
		mav.setViewName("productadded");
		return mav;
	}
	
	@RequestMapping(value="/viewallprod", method=RequestMethod.GET)
	public ModelAndView viewusers(HttpServletRequest request,HttpServletResponse response){
		
		List<Object[]> products = productService.getUsers();
		System.out.println(products.size());
		ModelAndView mav = new ModelAndView("viewallprod");
		mav.addObject("products", products);
		return mav;
	}
	
	
	
	
	
}
