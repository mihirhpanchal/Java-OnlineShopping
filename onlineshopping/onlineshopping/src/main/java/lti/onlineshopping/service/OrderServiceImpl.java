package lti.onlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lti.onlineshopping.dao.OrderDaoIntf;
import lti.onlineshopping.model.Order;
@Service("orderService")
public class OrderServiceImpl implements OrderServiceIntf {

	@Autowired
	OrderDaoIntf orderDao;
	public boolean addOrder(Order order) {
		System.out.println("Service is called");
		boolean flag=orderDao.addOrder(order);
		
		return flag;
	}

}
