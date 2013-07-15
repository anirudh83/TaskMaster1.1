package com.example.service;

import java.util.List;

import com.example.model.Meal;

public interface MealService {
	Meal createMeal(Meal meal);
	void deleteMeal(Long parseInt);
	List<Meal> getAllMeals(Long userId);
}
