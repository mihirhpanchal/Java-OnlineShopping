package lti.onlineshopping.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lti.onlineshopping.model.Cart;
import lti.onlineshopping.model.CartItem;
import lti.onlineshopping.model.Category;
import lti.onlineshopping.model.MyCart;
import lti.onlineshopping.model.MyCartItem;
import lti.onlineshopping.model.Order;
import lti.onlineshopping.model.OrderBack;
import lti.onlineshopping.model.OrderItemBack;
import lti.onlineshopping.model.Product;
import lti.onlineshopping.model.SubCategory;
import lti.onlineshopping.service.ProductServiceIntf;
  
@Controller("productController")
public class ProductController {
	@Autowired
	ProductServiceIntf productService;
		
	@RequestMapping(value="/placeorder",method=RequestMethod.GET)
	public ModelAndView palceorder(HttpServletRequest request,HttpServletResponse response)
	{
	ModelAndView mav = new ModelAndView("ordersucessful");
	
	String product_name=request.getParameter("product_name");
	Order myorder = new Order();
	return mav;
	}
	
	@RequestMapping(value = "/orderconfirm", method = RequestMethod.GET)
	public ModelAndView orderconfirm(Cart cart, HttpServletRequest request) {
			HttpSession session = request.getSession();
			MyCart mycart = (MyCart)session.getAttribute("mycart"); 
			List<MyCartItem> clist = mycart.getCartItem();
			OrderBack myorder = new OrderBack();
			myorder.setOrderItem(new ArrayList<OrderItemBack>());
			 for (MyCartItem item : clist) {
				OrderItemBack orderItem = new OrderItemBack();
				orderItem.setProdid(item.getProdid());
				orderItem.setQuantity(item.getQuantity());
				orderItem.setPrice(item.getPrice());
				myorder.getOrderItem().add(orderItem);
			 }
			System.out.println(myorder);
			ModelAndView mav = new ModelAndView("orderconfirm");
			mav.addObject("myorder",myorder);
			return mav;
		}
		

	@RequestMapping(value="/viewallprods",method=RequestMethod.GET)
	public ModelAndView viewallprods(HttpServletRequest request,HttpServletResponse response)
	{
	ModelAndView mav = new ModelAndView("viewallprod");
	return mav;
	}
	
	@RequestMapping(value = "/singleproduct", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request) {
		int prodid=Integer.parseInt(request.getParameter("prodid"));
		ModelAndView mav = new ModelAndView("singleproduct");
		mav.addObject("prodid",prodid);
		return mav;
	}

	
	@RequestMapping(value = "/viewmycart", method = RequestMethod.GET)
	public ModelAndView viewmycart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		MyCart mycart = (MyCart)session.getAttribute("mycart");
		
		ModelAndView mav = new ModelAndView("viewmycart");
		mav.addObject("mycart",mycart);
		return mav;
	}
	
	
	
	//addtocart.do
	
	@RequestMapping(value = "/addtocart", method = RequestMethod.POST)
	public ModelAndView addtocart(HttpServletRequest request) {
		int prodid=Integer.parseInt(request.getParameter("prodid"));
		int quantity=Integer.parseInt(request.getParameter("qty"));
		
		HttpSession session = request.getSession();
		MyCart mycart = (MyCart)session.getAttribute("mycart");
		if(mycart==null){
			System.out.println("cart not created");
			mycart = new MyCart();
			mycart.setCartItem(new ArrayList<MyCartItem>());
		}
		System.out.println(mycart);
		MyCartItem cartItem = new MyCartItem();
		cartItem.setProdid(prodid);
		cartItem.setQuantity(quantity);
		mycart.getCartItem().add(cartItem);
		session.setAttribute("mycart", mycart);
		
		System.out.println(mycart);
		ModelAndView mav = new ModelAndView("viewallprod");
		return mav;
	}
	
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
