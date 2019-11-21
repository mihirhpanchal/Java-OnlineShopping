package lti.onlineshopping.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/*
CREATE TABLE Category (
		category_id VARCHAR(10) not null primary key,
		category_name VARCHAR(255),
		category_description VARCHAR(255))
		
Insert into Category values (100,"Electronics","Electronic Products")
Insert into Category values (200,"Fashion","Fashion Products")
Insert into Category values (100,"Health","Health Products")
		*
		*/
import javax.persistence.Table;
		
@Entity
@Table(name="Category")
public class Category {

	
    @Id
    private String category_id;
    private String category_name;
    private String category_description;
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<SubCategory> subCategories;
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;

    



	public String getCategory_id() {
		return category_id;
	}


	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}


	public String getCategory_name() {
		return category_name;
	}


	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}


	public String getCategory_description() {
		return category_description;
	}


	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}


	public List<SubCategory> getSubCategories() {
		return subCategories;
	}


	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public Category() {
		super();
	}
    
    
}
