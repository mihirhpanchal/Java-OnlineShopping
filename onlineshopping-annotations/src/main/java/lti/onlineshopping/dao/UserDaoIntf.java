package lti.onlineshopping.dao;

import lti.onlineshopping.model.User;

public interface UserDaoIntf {

	public boolean insertUser(User user);
	public User validateUser(User user);
}
