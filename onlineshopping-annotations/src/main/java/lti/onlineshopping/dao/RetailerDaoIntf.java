package lti.onlineshopping.dao;

import java.util.List;

import lti.onlineshopping.model.AdminRetailers;
import lti.onlineshopping.model.Retailer;




public interface RetailerDaoIntf {
	
	public List<Retailer> getRetailers();
	public boolean removeRetailer(String id);
	public boolean insertRetailer(AdminRetailers adminretailers);

}
