package com.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.dao.MyDao;
import com.shopping.model.User;

@Service("myService")
public class MyService {

	@Autowired
	MyDao myDao;
	
	public boolean insertUser(User user) {
		boolean flag = MyDao.insertUser(user);
		return flag;
	}
	
	public User validateUser(User user) {
	    return myDao.validateUser(user);
	  }

}