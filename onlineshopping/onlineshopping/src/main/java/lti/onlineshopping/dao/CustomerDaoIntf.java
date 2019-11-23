package lti.onlineshopping.dao;

import java.util.List;

import lti.onlineshopping.model.Customer;


public interface CustomerDaoIntf {


	void addCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerByemailId(String emailId);
}
