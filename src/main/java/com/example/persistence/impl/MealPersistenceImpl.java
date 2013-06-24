package com.example.persistence.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Meal;
import com.example.persistence.MealPersistence;

/**
 * 
 * @author anirudh
 *
 */
@Repository
public class MealPersistenceImpl implements MealPersistence{
	
	 @Autowired
	 private SessionFactory sessionFactory;

	@Override
	public Meal createMeal(Meal meal) {
		Session sess = getSession();
		sess.save(meal);
		sess.close();
		return meal;
	}
	
	private Session getSession() {
		return sessionFactory.openSession();
	}
	
	public void refreshSession(){
		getSession().flush();
	}

	@Override
	public void delete(int mealId) {
		Session  session = getSession();
		session.delete(session.load(Meal.class, mealId));
		session.flush();
		session.close();
	}

}
