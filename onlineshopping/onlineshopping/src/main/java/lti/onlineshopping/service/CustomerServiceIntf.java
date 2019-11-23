package lti.onlineshopping.service;

import java.util.List;

import lti.onlineshopping.model.Customer;

public interface CustomerServiceIntf {


	void addCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerByemailId(String emailId);
}
