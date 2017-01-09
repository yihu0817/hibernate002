package com.ittx.hibernate002.server;

import com.ittx.hibernate002.dao.UserDao;
import com.ittx.hibernate002.dao.UserDaoImpl;
import com.ittx.hibernate002.model.User;

public class UserServerImpl implements UserServer {
	UserDao userDao = new UserDaoImpl();
	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

}
