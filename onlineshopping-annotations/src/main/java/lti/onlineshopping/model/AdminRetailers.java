package lti.onlineshopping.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class AdminRetailers {
	
	@Id
	private String id;
	private String retailername;
	private String email;
	private String mobileno;
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getRetailername() {
		return retailername;
	}
	
	public void setRetailername(String retailername) {
		this.retailername = retailername;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobileno() {
		return mobileno;
	}
	
	public void setMobile_no(String mobileno) {
		this.mobileno = mobileno;
	}
	
	public AdminRetailers(String id, String retailername, String email, String mobileno) {
		super();
		this.id = id;
		this.retailername = retailername;
		this.email = email;
		this.mobileno = mobileno;
	}
	
	public AdminRetailers() {
		super();
	}

	@Override
	public String toString() {
		return "AdminRetailers [id=" + id + ", retailername=" + retailername + ", email=" + email + ", mobileno="
				+ mobileno + "]";
	}
	
	

}
