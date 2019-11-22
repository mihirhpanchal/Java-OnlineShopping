package lti.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lti.onlineshopping.model.AdminRetailers;

import lti.onlineshopping.dao.RetailerDaoIntf;
import lti.onlineshopping.model.Retailer;


@Service("retailerService")
public class RetailerServiceImpl  implements RetailerServiceInt{
	
	@Autowired
	public RetailerDaoIntf retailerDao;
	
	@Transactional
	public List<Retailer> getRetailers() {
		 List<Retailer>  retailer = retailerDao. getRetailers();
		  return retailer;
		  
	}
	
	@Transactional
	public boolean removeRetailer(String id){
		return retailerDao.removeRetailer(id);
	}
	
	@Transactional
	public boolean insertRetailer(AdminRetailers adminretailers) {
		
		boolean flag = retailerDao.insertRetailer(adminretailers);
		return flag;
	}

}
