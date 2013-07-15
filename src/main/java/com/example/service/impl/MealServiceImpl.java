package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Meal;
import com.example.persistence.MealPersistence;
import com.example.service.MealService;
import com.example.service.UserService;

/**
 * 
 * @author anirudh
 *
 */
@Service
@Transactional
public class MealServiceImpl implements MealService{
	
	@Autowired
	private MealPersistence mealPersistence;
	
	@Autowired
	private UserService userService;

	@Override
	public Meal createMeal(Meal meal) {
		return mealPersistence.makePersistant(meal);
	}


	@Override
	public void deleteMeal(Long mealId) {
		Meal meal = mealPersistence.findById(mealId);
		mealPersistence.delete(meal);	
	}


	@Override
	public List<Meal> getAllMeals(Long userId) {
	 return mealPersistence.getAllMeals(userId);
	}

}
