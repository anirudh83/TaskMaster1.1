package com.example.persistence.impl;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.User;
import com.example.persistence.UserPersistence;

@Repository
public class UserPersistenceImpl implements UserPersistence{
	
	 @Autowired
	 private SessionFactory sessionFactory;

	@Override
	public User saveUser(User user) {
		Session sess = getSession();
		Transaction tx = sess.beginTransaction();
		sess.save(user);
		System.out.println("Successfully data inserted in database");
		tx.commit();
		return user;
	}

	private Session getSession() {
		Session sess = sessionFactory.openSession();
		return sess;
	}

	@Override
	public Set<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(long id) {
		Session sess = getSession();
		return (User) sess.get(User.class, id);
	}

	@Override
	public User getUserByEmail(String email) {
		Session sess = getSession();
		User user = (User) sess.createQuery(
			    "from User as user where user.email = ?")
			    .setString(0, email).uniqueResult();
		return user;
	}

}
