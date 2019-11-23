package lti.onlineshopping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "billingAddress")
public class BillingAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String billindAddressId;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private String country;

	/*@OneToOne(mappedBy = "billingAddress")
	private User user;*/

	
}
