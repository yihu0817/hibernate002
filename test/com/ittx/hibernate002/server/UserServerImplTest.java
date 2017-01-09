package com.ittx.hibernate002.server;

import org.junit.Test;

import com.ittx.hibernate002.model.User;


public class UserServerImplTest {
	UserServer userServer = new UserServerImpl();
	@Test
	public void testSaveUser() {
		User user = new User("张三","abcd");
		userServer.saveUser(user);
	}

}
