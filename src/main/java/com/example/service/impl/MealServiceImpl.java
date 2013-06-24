package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Meal;
import com.example.persistence.MealPersistence;
import com.example.service.MealService;

/**
 * 
 * @author anirudh
 *
 */
@Service
public class MealServiceImpl implements MealService{
	
	@Autowired
	private MealPersistence mealPersistence;

	@Override
	public Meal createMeal(Meal meal) {
		return mealPersistence.createMeal(meal);
	}

	@Override
	public void refresh() {
		mealPersistence.refreshSession();		
	}

	@Override
	public void deleteMeal(int mealId) {
		mealPersistence.delete(mealId);	
	}
	

}
