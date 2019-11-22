package lti.onlineshopping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class Retailer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	private String retailer_name;
	private String product_name;
	private String product_category;
	private String product_subcategory;
	private String quantity;
	private String products_left;
	private String products_sold;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRetailer_name() {
		return retailer_name;
	}
	public void setRetailer_name(String retailer_name) {
		this.retailer_name = retailer_name;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	public String getProduct_subcategory() {
		return product_subcategory;
	}
	public void setProduct_subcategory(String product_subcategory) {
		this.product_subcategory = product_subcategory;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getProducts_left() {
		return products_left;
	}
	public void setProducts_left(String products_left) {
		this.products_left = products_left;
	}
	public String getProducts_sold() {
		return products_sold;
	}
	public void setProducts_sold(String products_sold) {
		this.products_sold = products_sold;
	}
	public Retailer(String id, String retailer_name, String product_name, String product_category,
			String product_subcategory, String quantity, String products_left, String products_sold) {
		super();
		this.id = id;
		this.retailer_name = retailer_name;
		this.product_name = product_name;
		this.product_category = product_category;
		this.product_subcategory = product_subcategory;
		this.quantity = quantity;
		this.products_left = products_left;
		this.products_sold = products_sold;
	}
	public Retailer() {
		super();
	}
	

}