package lti.onlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lti.onlineshopping.dao.UserDaoIntf;
import lti.onlineshopping.model.User;


@Service("userService")
public class UserServiceImpl implements UserServiceIntf{

	@Autowired
	UserDaoIntf userDao;
	
	@Transactional
	public boolean insertUser(User user) {
		boolean flag = userDao.insertUser(user);
		System.out.println(flag);
		return flag;
	}
	
	@Transactional
	public User validateUser(User user) {
	    return userDao.validateUser(user);
	  }

}