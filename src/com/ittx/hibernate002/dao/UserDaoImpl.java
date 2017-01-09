package com.ittx.hibernate002.dao;

import org.hibernate.Session;

import com.ittx.hibernate002.model.User;
import com.ittx.hibernate002.utils.HibernateUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public void saveUser(User user) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
}
