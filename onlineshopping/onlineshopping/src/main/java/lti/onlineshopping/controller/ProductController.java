package lti.onlineshopping.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lti.onlineshopping.model.CartItem;
import lti.onlineshopping.model.Category;
import lti.onlineshopping.model.MyCart;
import lti.onlineshopping.model.Order;
import lti.onlineshopping.model.OrderItem;
import lti.onlineshopping.model.Product;
import lti.onlineshopping.model.SubCategory;
import lti.onlineshopping.service.OrderServiceIntf;
import lti.onlineshopping.service.ProductServiceIntf;
  
@Controller("productController")
public class ProductController {
	@Autowired
	ProductServiceIntf productService;
	@Autowired
	OrderServiceIntf orderService;
	@RequestMapping(value="/placeorder",method=RequestMethod.GET)
	public ModelAndView placeorder(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		MyCart mycart = (MyCart)session.getAttribute("mycart"); 
		String username = session.getAttribute("username").toString();
		System.out.println(username);
		List<CartItem> clist = mycart.getCartItem();
		Order myorder = new Order();
		myorder.setUsername(username);
		myorder.setOrderItem(new ArrayList<OrderItem>());
		//String username = session.getAttribute("username").toString();
		//myorder.setUsername(username);
		 for (CartItem item : clist) {
			 
			int prodid = item.getProduct_id();
			System.out.println(prodid);
			 
			OrderItem orderItem = new OrderItem();
			orderItem.setProdid(item.getProduct_id());
			orderItem.setQuantity(item.getQuantity());
			orderItem.setPrice(item.getPrice());
			myorder.getOrderItem().add(orderItem);
		 }
		System.out.println(myorder);
		boolean flag = orderService.addOrder(myorder);
		System.out.println(flag);
		int myorderid = myorder.getOrderid();
		ModelAndView mav = new ModelAndView("ordersucessful");
		mav.addObject("myorderid",myorderid);
		return mav;
	}
	
	@RequestMapping(value = "/orderconfirm", method = RequestMethod.GET)
	public ModelAndView orderconfirm(MyCart cart, HttpServletRequest request) {
			HttpSession session = request.getSession();
			MyCart mycart = (MyCart)session.getAttribute("mycart"); 
			List<CartItem> clist = mycart.getCartItem();
			Order myorder = new Order();
			myorder.setOrderItem(new ArrayList<OrderItem>());
			 for (CartItem item : clist) {
				OrderItem orderItem = new OrderItem();
				orderItem.setProdid(item.getProduct_id());
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
/*	
	@RequestMapping(value = "/singleproduct", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request) {
		int prodid=Integer.parseInt(request.getParameter("prodid"));
		ModelAndView mav = new ModelAndView("singleproduct");
		mav.addObject("prodid",prodid);
		return mav;
	}
*/
	
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
		String price = request.getParameter("unitprice");
		System.out.println("price:"+price);
		HttpSession session = request.getSession();
		MyCart mycart = (MyCart)session.getAttribute("mycart");
		if(mycart==null){
			System.out.println("cart not created");
			mycart = new MyCart();
			mycart.setCartItem(new ArrayList<CartItem>());
		}
		System.out.println(mycart);
		CartItem cartItem = new CartItem();
		cartItem.setProduct_id(prodid);
		cartItem.setQuantity(quantity);
		cartItem.setPrice(price);
		mycart.getCartItem().add(cartItem);
		session.setAttribute("mycart", mycart);
		
		System.out.println(mycart);
		ModelAndView mav = new ModelAndView("viewallprod");
		return mav;
	}
	
	 @RequestMapping(value = "/insertproduct.do", method = RequestMethod.GET)
	  public ModelAndView showRegister2(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("regproduct");
	    mav.addObject("product", new Product());
	    return mav;
	  }
		
	@RequestMapping(value="/insertproduct.do",method=RequestMethod.POST)
	public ModelAndView insertContact(HttpServletRequest request,HttpServletResponse response,   @RequestParam("file") MultipartFile files[])
	{
		String product_name=request.getParameter("product_name");
		String brand=request.getParameter("brand");
		String product_description=request.getParameter("product_description");
		String unit_price=request.getParameter("unit_price");
		String quantity=request.getParameter("quantity");
		String categoryname=request.getParameter("category");
		String subcategoryname=request.getParameter("subcategory");
		String filename=request.getParameter("filename");
		
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
		product.setQuantity(quantity);
		product.setCategory(category);
		product.setSubcategory(subcategory);
		product.setDate_added(date);
		product.setFilename(filename);
		
		String product_name1 = product.getProduct_name();
		
		//uploading files
		for (int i = 0; i < files.length; i++) {
		/*String*/ filename="";
		if(i==0)
			/*filename=(product_name+i)+".pdf";
			else if(i==1)
				filename=(product_name+i)+".pdf";
			else if(i==2)
*/					filename=(product_name+i)+".jpg";
		MultipartFile file = files[i];
		try {
			byte[] bytes = file.getBytes();

			// Creating the directory to store file
			String rootPath = System.getProperty("catalina.home");
			File dir = new File(rootPath + File.separator + "tmpFiles");
			if (!dir.exists())
				dir.mkdirs();

			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath()+ File.separator + filename);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
			
			if(i==0)
           product.setFilename(filename);
			/*else if(i==1)
				user.setDob_fname(filename;)
			else if(i==2)
				user.setImage(filename);
			user.setStatus("N");*/
			
			System.out.println("Server File Location="+ serverFile.getAbsolutePath());
			} catch (Exception e) {
			System.out.println( "You failed to upload " + (product_name+i) + " => " + e.getMessage());
		}
		}
	
		
		
		boolean flag= productService.insertProduct(product);
		ModelAndView mav=new ModelAndView();
		mav.addObject("product_name",product_name);
		mav.addObject("product_description",product_description);
		mav.addObject("unit_price",unit_price);
		mav.addObject("quantity",quantity);
		mav.addObject("category_id",cid);
		mav.addObject("sub_id",sid);
		mav.addObject(date);
		mav.addObject(filename, filename);
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
		
		List<Object[]> products = productService.getProducts();
		System.out.println(products.size());
		ModelAndView mav = new ModelAndView("viewallprod");
		mav.addObject("products", products);
		return mav;
	}
	
	@RequestMapping(value = "/singleproduct", method = RequestMethod.GET)
	public ModelAndView fetchDetails(HttpServletRequest request) {
		int prodid=Integer.parseInt(request.getParameter("prodid"));
		
		Product products = productService.fetchDetails(prodid);
	   
		
		ModelAndView mav = new ModelAndView("singleproduct");
		mav.addObject("prodid", prodid);
		mav.addObject("products",products);
		return mav;
	}
	
	
	@RequestMapping(value = "/singleproductforcompare", method = RequestMethod.GET)
	public ModelAndView compare(HttpServletRequest request) {
		int prodid=Integer.parseInt(request.getParameter("prodid"));
		Product products = productService.compareProduct(prodid);
		ModelAndView mav = new ModelAndView("compare");
		mav.addObject("products",products);
		
		return mav;
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public ModelAndView viewSearchResults(HttpServletRequest request,HttpServletResponse response){
		
		String search = request.getParameter("search");
		
		System.out.println(search);
		
		List<Product> searchList = productService.searchKeywords(search);
		if(searchList.size()!=0){
			System.out.println( searchList.size());
			ModelAndView mav = new ModelAndView("viewsearchresults");
			mav.addObject("searchList", searchList);
			return mav;
		}
		else{
			ModelAndView mav = new ModelAndView("nosearchresult");
			mav.addObject("result", "Sorry, no product for the proposed search found");
			return mav;
		}

	}
	
	@RequestMapping(value = "/removeproduct", method = RequestMethod.GET)
	public ModelAndView removeProduct( HttpServletRequest request,HttpServletResponse response){
		
		int prodid=Integer.parseInt(request.getParameter("prodid"));
		boolean flag = productService.removeProduct(prodid);
		ModelAndView mav = new ModelAndView("deletedproduct");
		mav.addObject("text","Product successfully deleted");
		 return mav;
		}
	
}
	
	
	
	
	

