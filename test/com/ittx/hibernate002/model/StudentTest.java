package com.ittx.hibernate002.model;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {
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
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	@Test
	public void testSaveStudent() {
		Student student = new Student(1002, "张三", 18,"男",new Date());
		session.save(student);
		
//		Student student = new Student(1001, "小丽", 23,"女",new Date());
//		session.update(student);
	}
}
