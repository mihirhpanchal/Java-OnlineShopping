package lti.onlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lti.onlineshopping.dao.UserDaoIntf;
import lti.onlineshopping.model.User;


@Service("userService")
public class UserServiceImpl implements UserServiceIntf{

	@Autowired
	UserDaoIntf userDao;
	
	public boolean insertUser(User user) {
		boolean flag = userDao.insertUser(user);
		System.out.println(flag);
		return flag;
	}
	
	public User validateUser(User user) {
	    return userDao.validateUser(user);
	  }

}