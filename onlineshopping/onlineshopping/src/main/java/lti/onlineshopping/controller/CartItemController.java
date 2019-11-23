package lti.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import lti.onlineshopping.model.Cart;
import lti.onlineshopping.model.CartItem;
import lti.onlineshopping.model.Customer;
import lti.onlineshopping.model.Product;
import lti.onlineshopping.model.User;
import lti.onlineshopping.service.CartItemServiceIntf;
import lti.onlineshopping.service.CartServiceIntf;
import lti.onlineshopping.service.CustomerServiceIntf;
import lti.onlineshopping.service.ProductServiceIntf;

@Controller("cartItemController")
public class CartItemController {

	@Autowired
	private CartServiceIntf cartService;

	@Autowired
	private CartItemServiceIntf cartItemService;

	@Autowired
	private CustomerServiceIntf customerService;

	@Autowired
	private ProductServiceIntf productService;

	
	public CustomerServiceIntf getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerServiceIntf customerService) {
		this.customerService = customerService;
	}

	public ProductServiceIntf getProductService() {
		return productService;
	}

	public void setProductService(ProductServiceIntf productService) {
		this.productService = productService;
	}

	public CartServiceIntf getCartService() {
		return cartService;
	}

	public void setCartService(CartServiceIntf cartService) {
		this.cartService = cartService;
	}

	public CartItemServiceIntf getCartItemService() {
		return cartItemService;
	}

	public void setCartItemService(CartItemServiceIntf cartItemService) {
		this.cartItemService = cartItemService;
	}

	@RequestMapping("/cart/add/{productId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addCartItem(@PathVariable(value = "productId") String productId) {
		//User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = new User();
		String emailId = user.getUsername();
		Customer customer = customerService.getCustomerByemailId(emailId);
		System.out.println("Customer : " + customer.getUsers().getEmail());
		Cart cart = customer.getCart();
		System.out.println(cart);
		List<CartItem> cartItems = cart.getCartItem();
		Product product = productService.getProductById(productId);
		for (int i = 0; i < cartItems.size(); i++) {
			CartItem cartItem = cartItems.get(i);
			if (product.getProduct_id()==(cartItem.getProduct().getProduct_id())) {
				cartItem.setQuality(cartItem.getQuality() + 1);
				Float price = Float.parseFloat(cartItem.getProduct().getUnit_price());
				cartItem.setPrice(cartItem.getQuality() * price);
				cartItemService.addCartItem(cartItem);
				return;
			}
		}
		CartItem cartItem = new CartItem();
		cartItem.setQuality(1);
		cartItem.setProduct(product);
		Float price = Float.parseFloat(cartItem.getProduct().getUnit_price());
		cartItem.setPrice(price*1);
		cartItem.setCart(cart);
		cartItemService.addCartItem(cartItem);
	}

	@RequestMapping("/cart/removeCartItem/{cartItemId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeCartItem(@PathVariable(value = "cartItemId") String cartItemId) {
		cartItemService.removeCartItem(cartItemId);
	}

	@RequestMapping("/cart/removeAllItems/{cartId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeAllCartItems(@PathVariable(value = "cartId") String cartId) {
		Cart cart = cartService.getCartByCartId(cartId);
		cartItemService.removeAllCartItems(cart);
	}
}
