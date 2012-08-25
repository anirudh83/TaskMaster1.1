package com.example.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Task;

public class TaskPersistence {

	public void saveTask(Task task) {
		Session sess = null;
		try {
			System.out.println("got into hibertane");
			sess = HibernateUtil.currentSession();
			Transaction tx = sess.beginTransaction();
			sess.save(task);
			System.out.println("Successfully data insert in database");
			tx.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sess.close();
		}
	}
}