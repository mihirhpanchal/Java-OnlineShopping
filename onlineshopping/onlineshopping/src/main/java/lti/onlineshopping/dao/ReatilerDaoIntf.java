package lti.onlineshopping.dao;

import java.util.List;

import lti.onlineshopping.model.Retailer;




public interface ReatilerDaoIntf {
	
	public List<Retailer> getRetailers();
	public boolean removeRetailer(String id);

}
