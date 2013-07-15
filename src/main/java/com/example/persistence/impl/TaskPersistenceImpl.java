package com.example.persistence.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.example.model.Task;
import com.example.persistence.TaskPersistence;

@Repository
public class TaskPersistenceImpl extends GenericDAOImpl<Task, Long> implements TaskPersistence{
	

	public List<Task> getAllTasks() {
			System.out.println("opening session");
			Session sess = getSession();
			List<Task> result = sess.createQuery("from Task").list();
		return result;
	}

	@Override
	public List<Task> getAllTasks(String email) {
		Session sess = getSession();
		List<Task> tasks = sess.createQuery(
			    "from Task as task where task.createdBy.email = ?")
			    .setString(0, email).list();
		return tasks;
	}

	@Override
	public Task findById(Long id){
		return (Task)getSession().get(getPersistenceClass(), id);
	}
	
}
