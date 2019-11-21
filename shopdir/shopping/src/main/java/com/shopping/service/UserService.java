package com.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.dao.UserDao;
import com.shopping.model.User;

@Service("myService")
public class UserService {

	@Autowired
	UserDao myDao;
	
	public boolean insertUser(User user) {
		boolean flag = UserDao.insertUser(user);
		return flag;
	}
	
	public User validateUser(User user) {
	    return myDao.validateUser(user);
	  }

}