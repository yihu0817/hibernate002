package com.ittx.hibernate002.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	SessionFactory sessionFactory;
	Transaction transaction;
	Session session;

	@Before
	public void setUp() throws Exception {
		// 读取hibernate.cfg.xml文件
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
				.build();
		// 建立SessionFactory
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
		transaction.commit();
	}

	/**
	 * HQL查询
	 * 适用情况：常用方法，比较传统，类似jdbc。缺点：新的查询语言,适用于Hibernate框架。
	 */
	@Test
	public void testQueryHQLUser() {
		Query query = session.createQuery("FROM User as user where user.id=:si");
//		query.setInteger("id", 3);
		query.setParameter("si", 2);
		List<User> userLists = query.list();
		for (User user : userLists) {
			System.out.println(user);
		}

	}
	/**
	 * SQL查询
	 * 适用情况：不熟悉HQL的朋友，又不打算转数据库平台的朋友，万能方法   缺点：破坏跨平台，不易维护，不面向对象。
	 */
	@Test
	public void testQuerySqlUser(){
		SQLQuery query = session.createSQLQuery("select * from user").addEntity(User.class);
		List<User> userLists = query.list();
		for (User user : userLists) {
			System.out.println(user);
		}
	}
}
