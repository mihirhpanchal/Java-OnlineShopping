package lti.onlineshopping.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
CREATE TABLE SubCategory (
		sub_id VARCHAR(10) not null primary key,
		sub_name VARCHAR(255),
		sub_desc VARCHAR(255))
		categoryid int references Category(category_id)).
		
		Insert into Subcategory values ("S1","Mobile","Mobile Products",100)
		Insert into Subcategory values ("S2","Shoes","Shoe Products",200)
		Insert into Subcategory values ("S3","Medicine","Medicine Products",300)
		*/

@Entity
@Table(name="SubCategory")
public class SubCategory {

	@Id
	private String sub_id;
	private String sub_name;
	private String sub_desc;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
	public String getSub_id() {
		return sub_id;
	}
	public void setSub_id(String sub_id) {
		this.sub_id = sub_id;
	}
	public String getSub_desc() {
		return sub_desc;
	}
	public void setSub_desc(String sub_desc) {
		this.sub_desc = sub_desc;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	public SubCategory() {
		super();
	}
    
    
}
