package lti.onlineshopping.service;

import lti.onlineshopping.model.CustomerOrder;

public interface OrderServiceIntf {


	void addCustomerOrder(CustomerOrder customerOrder);
	double getCustomerOrderGrandTotal(String cartId);
}
