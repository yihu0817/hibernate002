package com.ittx.hibernate002.model;

import java.util.Date;
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
//		session = sessionFactory.openSession();
		session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
	}
	
	@After
	public void tearDown() throws Exception {
		transaction.commit();
//		session.close();
//		sessionFactory.close();
	}

	@Test
	public void testSaveStudent() {
		Student student = new Student(1001, "小丽", 18,"男",new Date());
		session.save(student);
		
		student = new Student(1002, "小明", 23,"女",new Date());
		session.save(student);
		
//		Student student = new Student(1001, "小明", 23,"女",new Date());
//		session.delete(student);
		
	}
	/**
	 * SQL方法
	 * 
	 */
	@Test
	public void testQueryStudent(){
		String sql = "select * from student where age=18 or number=1002 order by age DESC";
		SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(Student.class);
		List<Student> list = sqlQuery.list();
		for(Student student:list){
			System.out.println(student);
		}
	}
	/**
	 * HSQL方法
	 */
	@Test
	public void testHQLStudent(){
		String hsql = "FROM Student";
		Query query = session.createQuery(hsql);
		List<Student> list = query.list();
		for(Student student:list){
			System.out.println(student);
		}
	}
	/**
	 * HSQL
	 * 
	 */
	@Test
	public void testHQLStudentValue(){
		String hsql = "SELECT count(*) FROM Student";
		Query query = session.createQuery(hsql);
		Long r = (Long) query.uniqueResult();
		System.out.println(r);
	}
	/**
	 * 查找指定属性记录
	 * 1.创建包含查询属性构造方法
	 * 2.若查询结果唯一，用uniqueResult()，有多条结果，用list()
	 */
	@Test
	public void testHQLStudentSelect(){
		String hsql = "SELECT new Student(s.name,s.number) FROM Student AS s where s.number=:num";
		Query query = session.createQuery(hsql);
		query.setParameter("num", 1001);
		Student r = (Student) query.uniqueResult();
		System.out.println(r);
	}
	
}
