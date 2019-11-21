package lti.onlineshopping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lti.onlineshopping.model.Retailer;

@Service
public interface RetailerServiceInt {
	
	public List<Retailer> getRetailers();
	public boolean removeRetailer(String id);

}
