package com.example.persistence.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Task;
import com.example.persistence.TaskPersistence;

@Repository
public class TaskPersistenceImpl implements TaskPersistence{
	
	 @Autowired
	 private SessionFactory sessionFactory;

	public void saveTask(Task task) {
			Session sess = sessionFactory.openSession();
			Transaction tx = sess.beginTransaction();
			sess.save(task);
			System.out.println("Successfully data inserted in database");
			tx.commit();
		
	}

	public List<Task> getAllTasks() {
			System.out.println("opening session");
			Session sess = sessionFactory.openSession();
			System.out.println("sessionFactory :" +sessionFactory.getClass());
			Transaction tx = sess.beginTransaction();
			List<Task> result = sess.createQuery("from Task").list();
			tx.commit();
		return result;
	}


}
