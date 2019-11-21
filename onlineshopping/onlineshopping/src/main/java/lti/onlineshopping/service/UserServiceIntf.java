package lti.onlineshopping.service;

import lti.onlineshopping.model.User;

public interface UserServiceIntf {

	public boolean insertUser(User user);
	
	public User validateUser(User user);
}
